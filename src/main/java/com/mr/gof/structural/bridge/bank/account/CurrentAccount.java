package com.mr.gof.structural.bridge.bank.account;

import com.mr.gof.structural.bridge.bank.Currency;
import com.mr.gof.structural.bridge.bank.Person;
import com.mr.gof.structural.bridge.bank.card.Card;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CurrentAccount implements Account{

    private final String number;

    private final Person owner;

    private final Currency baseCurrency;

    private BigDecimal currentBalance;

    private final List<Card> cards = new ArrayList<>();

    public CurrentAccount(String number, Person owner, Currency baseCurrency, BigDecimal currentBalance) {
        this.number = number;
        this.owner = owner;
        this.baseCurrency = baseCurrency;
        this.currentBalance = currentBalance;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    @Override
    public BigDecimal getCurrentBalance() {
        return null;
    }

    @Override
    public void transfer(BigDecimal amount) {
        var updatedBalance = currentBalance.add(amount);
        if (updatedBalance.signum() == -1){
            throw new IllegalArgumentException("Not enough balance");
        }
        currentBalance = updatedBalance;
    }

    @Override
    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentAccount that)) return false;
        return getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
