package com.mr.gof.behavioral.mediator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mr.gof.behavioral.mediator.Currency;

public class TransferCurrencyModel extends BaseModel{
  private Currency selectedCurrency;

  private Set<Currency> currencies = new HashSet<>();

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
    this.currencies = new HashSet<>(currencies);
  }
}
