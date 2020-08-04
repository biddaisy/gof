package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.Currency;
import com.mr.gof.behavioral.mediator.InstrumentResolver;

import java.util.ArrayList;
import java.util.List;

public class TransferCurrencyModel extends BaseModel{
  private Currency selectedCurrency;

  private List<Currency> currencies = new ArrayList<Currency>();

  public Currency getSelectedCurrency() {
    return selectedCurrency;
  }

  public void setSelectedCurrency(Currency selectedCurrency) {
    this.selectedCurrency = selectedCurrency;
    changed();
  }

  public List<Currency> getCurrencies() {
    return new ArrayList<>(currencies);
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }
}
