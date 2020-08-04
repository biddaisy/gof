package com.mr.gof.behavioral.mediator;

import java.util.Collections;
import java.util.List;

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
  }

  private void currencyModelChanged(TransferCurrencyModel model) {
    Currency transferCurrency = model.getSelectedCurrency();
    Account orderingAccount = modelComposer.getAccountModel().getSelectedAccount();
    List<Country> beneficiaryCountries = transferCurrency != null ? instruments.getServiceLevels(orderingAccount.getBank(), transferCurrency) : null;
    List<Beneficiary> beneficiaries = Beneficiaries.INSTANCE.getBeneficiaryListByCountries(beneficiaryCountries);
    BeneficiaryModel beneficiaryModel = modelComposer.getBeneficiaryModel();
    beneficiaryModel.setBeneficiaries(beneficiaries);
    beneficiaryModel.setSelectedBeneficiary(beneficiaries.size() == 1? beneficiaries.get(0):null);
  }

  private void accountModelChanged(OrderingAccountModel model) {
    Account currentAccount = model.getSelectedAccount();
    List<Currency> transferCurrencies = currentAccount != null ? instruments.getTransferCurrencies(currentAccount.getBank()) : Collections.emptyList();
    TransferCurrencyModel transferCurrencyModel = modelComposer.getCurrencyModel();
    transferCurrencyModel.setCurrencies(transferCurrencies);
    transferCurrencyModel.setSelectedCurrency(transferCurrencies.size() == 1 ? transferCurrencies.get(0) : null);
  }
}
