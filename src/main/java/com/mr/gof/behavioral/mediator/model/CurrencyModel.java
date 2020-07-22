package com.mr.gof.behavioral.mediator.model;

import com.mr.gof.behavioral.mediator.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
  private Currency selectedCurrency;

  private List<Currency> currencies = new ArrayList<Currency>();

  public Currency getSelectedCurrency() {
    return selectedCurrency;
  }

  public void setSelectedCurrency(Currency selectedCurrency) {
    this.selectedCurrency = selectedCurrency;
  }

  public List<Currency> getCurrencies() {
    return new ArrayList<Currency>(currencies);
  }
}
