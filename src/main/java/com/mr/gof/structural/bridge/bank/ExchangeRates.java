package com.mr.gof.structural.bridge.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class ExchangeRates {
  
  private final Set<ExchangeRate> rates =
      Set.of(
              new ExchangeRate(Currency.USD, Currency.EUR, BigDecimal.valueOf(1.08)),
              new ExchangeRate(Currency.BYN, Currency.USD, BigDecimal.valueOf(2.7)),
              new ExchangeRate(Currency.RUB, Currency.USD, BigDecimal.valueOf(70)),
              new ExchangeRate(Currency.BYN, Currency.RUB, BigDecimal.valueOf(0.0351))
      );

  public static final ExchangeRates EXCHANGE_RATES = new ExchangeRates();
  
  private ExchangeRates(){}
  
  public BigDecimal getExchangeRate(Currency currency1, Currency currency2) {
    for (var rate : rates) {
      if (rate.getCurrency1() == currency1 && rate.getCurrency2() == currency2)
        return rate.getRate();
      if (rate.getCurrency2() == currency1 && rate.getCurrency1() == currency2)
        return BigDecimal.ONE.divide(rate.getRate(), RoundingMode.HALF_UP);
    }
    throw new IllegalArgumentException(String.format("Rate for %s and %s not found", currency1, currency2));
  }
}
