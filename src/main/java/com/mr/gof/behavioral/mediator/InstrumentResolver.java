package com.mr.gof.behavioral.mediator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.mr.gof.behavioral.mediator.model.*;

public class InstrumentResolver {

  private final ModelComposer modelComposer = new ModelComposer();

  private final Instruments instruments = new Instruments();

  public InstrumentResolver() {
    modelComposer.init(this);
  }

  public ModelComposer getModelComposer() {
    return modelComposer;
  }

  public void modelChanged(BaseModel model) {
    if (model instanceof OrderingAccountModel) {
      accountModelChanged((OrderingAccountModel) model);
    }
    else
      if (model instanceof TransferCurrencyModel) {
        currencyModelChanged((TransferCurrencyModel) model);
      }
      else
        if (model instanceof BeneficiaryModel) {
          beneficiaryModelChanged((BeneficiaryModel) model);
        }
  }

  public List<Instrument> getSelectedInstruments() {
    Account orderingAccount = modelComposer.getOrderingAccountModel().getSelectedAccount();
    Currency transferCurrency = modelComposer.getTransferCurrencyModel().getSelectedCurrency();
    Beneficiary beneficiary = modelComposer.getBeneficiaryModel().getSelectedBeneficiary();
    ServiceLevel serviceLevel = modelComposer.getServiceLevelModel().getSelectedServiceLevel();
    if (orderingAccount == null || transferCurrency == null || beneficiary == null || serviceLevel == null) {
      return Collections.emptyList();
    }
    else {
      return instruments.getInstrumentList().stream()
          .filter(i -> i.getBank() == orderingAccount.getBank() && i.getTransferCurrencies().contains(transferCurrency)
              && i.getBeneficiaryCountry() == beneficiary.getCountry() && i.getServiceLevel() == serviceLevel)
          .collect(Collectors.toList());
    }
  }

  private void beneficiaryModelChanged(BeneficiaryModel model) {
    Account orderingAccount = modelComposer.getOrderingAccountModel().getSelectedAccount();
    Currency transferCurrency = modelComposer.getTransferCurrencyModel().getSelectedCurrency();
    Beneficiary beneficiary = model.getSelectedBeneficiary();
    List<ServiceLevel> serviceLevels =
        beneficiary != null ? instruments.getServiceLevels(orderingAccount.getBank(), transferCurrency, beneficiary.getCountry()) : Collections.emptyList();
    ServiceLevelModel serviceLevelModel = modelComposer.getServiceLevelModel();
    serviceLevelModel.setServiceLevels(serviceLevels);
    serviceLevelModel.setSelectedServiceLevel(serviceLevels.size() == 1 ? serviceLevels.get(0) : null);
  }

  private void currencyModelChanged(TransferCurrencyModel model) {
    Currency transferCurrency = model.getSelectedCurrency();
    Account orderingAccount = modelComposer.getOrderingAccountModel().getSelectedAccount();
    List<Country> beneficiaryCountries =
        transferCurrency != null ? instruments.getBeneficiaryCountries(orderingAccount.getBank(), transferCurrency) : Collections.emptyList();
    List<Beneficiary> beneficiaries = Beneficiaries.INSTANCE.getBeneficiaryListByCountries(beneficiaryCountries);
    BeneficiaryModel beneficiaryModel = modelComposer.getBeneficiaryModel();
    beneficiaryModel.setBeneficiaries(beneficiaries);
    beneficiaryModel.setSelectedBeneficiary(beneficiaries.size() == 1 ? beneficiaries.get(0) : null);
  }

  private void accountModelChanged(OrderingAccountModel model) {
    Account currentAccount = model.getSelectedAccount();
    List<Currency> transferCurrencies = currentAccount != null ? instruments.getTransferCurrencies(currentAccount.getBank()) : Collections.emptyList();
    TransferCurrencyModel transferCurrencyModel = modelComposer.getTransferCurrencyModel();
    transferCurrencyModel.setCurrencies(transferCurrencies);
    transferCurrencyModel.setSelectedCurrency(transferCurrencies.size() == 1 ? transferCurrencies.get(0) : null);
  }
}
