package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.InstrumentResolver;

public class ModelComposer {

  private final AccountModel accountModel = new AccountModel();

  private final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();

  private final CurrencyModel currencyModel = new CurrencyModel();

  private final ServiceLevelModel serviceLevelModel = new ServiceLevelModel();

  public void init(InstrumentResolver instrumentResolver) {
    accountModel.setInstrumentResolver(instrumentResolver);
    beneficiaryModel.setInstrumentResolver(instrumentResolver);
    currencyModel.setInstrumentResolver(instrumentResolver);
    serviceLevelModel.setInstrumentResolver(instrumentResolver);
  }

  public AccountModel getAccountModel() {
    return accountModel;
  }

  public BeneficiaryModel getBeneficiaryModel() {
    return beneficiaryModel;
  }

  public CurrencyModel getCurrencyModel() {
    return currencyModel;
  }

  public ServiceLevelModel getServiceLevelModel() {
    return serviceLevelModel;
  }
}
