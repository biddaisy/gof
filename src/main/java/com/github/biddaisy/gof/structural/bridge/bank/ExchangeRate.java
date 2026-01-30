package com.github.biddaisy.gof.structural.bridge.bank;

import java.math.BigDecimal;

public class ExchangeRate {

    private final Currency currency1;

    private final Currency currency2;

    private BigDecimal rate;

    public ExchangeRate(Currency currency1, Currency currency2, BigDecimal rate) {
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.rate = rate;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public Currency getCurrency2() {
        return currency2;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
