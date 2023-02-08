package com.mr.gof.structural.bridge.bank;

import com.mr.gof.structural.bridge.bank.card.Card;

import java.math.BigDecimal;
import java.util.Objects;

public class Atm {

    private final String id;

    public Atm(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void withdraw(Card card, BigDecimal amount, Currency currency){
        card.withdraw(amount, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atm atm)) return false;
        return getId().equals(atm.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
