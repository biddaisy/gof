package com.mr.gof.behavioral.mediator;

import java.util.Collections;
import java.util.List;

import com.mr.gof.behavioral.mediator.model.AccountModel;
import com.mr.gof.behavioral.mediator.model.BaseModel;
import com.mr.gof.behavioral.mediator.model.CurrencyModel;
import com.mr.gof.behavioral.mediator.model.ModelComposer;

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
    if (model instanceof AccountModel) {
      Account currentAccount = ((AccountModel) model).getSelectedAccount();
      List<Currency> transferCurrencies = currentAccount != null ? instruments.getTransferCurrencies(currentAccount.getBank()) : Collections.emptyList();
      CurrencyModel currencyModel = modelComposer.getCurrencyModel();
      currencyModel.setCurrencies(transferCurrencies);
      currencyModel.setSelectedCurrency(transferCurrencies.size() == 1 ? transferCurrencies.get(0) : null);
    }
  }
}
