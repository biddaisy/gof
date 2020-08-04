package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.InstrumentResolver;

public class ModelComposer {

  private final OrderingAccountModel orderingAccountModel = new OrderingAccountModel();

  private final BeneficiaryModel beneficiaryModel = new BeneficiaryModel();

  private final TransferCurrencyModel transferCurrencyModel = new TransferCurrencyModel();

  private final ServiceLevelModel serviceLevelModel = new ServiceLevelModel();

  public void init(InstrumentResolver instrumentResolver) {
    orderingAccountModel.setInstrumentResolver(instrumentResolver);
    beneficiaryModel.setInstrumentResolver(instrumentResolver);
    transferCurrencyModel.setInstrumentResolver(instrumentResolver);
    serviceLevelModel.setInstrumentResolver(instrumentResolver);
  }

  public OrderingAccountModel getAccountModel() {
    return orderingAccountModel;
  }

  public BeneficiaryModel getBeneficiaryModel() {
    return beneficiaryModel;
  }

  public TransferCurrencyModel getCurrencyModel() {
    return transferCurrencyModel;
  }

  public ServiceLevelModel getServiceLevelModel() {
    return serviceLevelModel;
  }
}
