package com.github.biddaisy.gof.structural.bridge.bank;

import static com.github.biddaisy.gof.structural.bridge.bank.Currency.EUR;
import static com.github.biddaisy.gof.structural.bridge.bank.Currency.USD;
import static com.github.biddaisy.gof.structural.bridge.bank.card.PaymentSystem.MASTERCARD;
import static com.github.biddaisy.gof.structural.bridge.bank.card.PaymentSystem.VISA;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.github.biddaisy.gof.structural.bridge.bank.account.CurrentAccount;
import com.github.biddaisy.gof.structural.bridge.bank.account.SavingAccount;
import com.github.biddaisy.gof.structural.bridge.bank.card.CreditCard;
import com.github.biddaisy.gof.structural.bridge.bank.card.DebitCard;

public class Test {

    public static void main(String... args) {
        var bank1 = new Bank("Bank 1");
        var person1 = new Person("Person 1");
        var currentAccount1 = new CurrentAccount("1", person1, USD, BigDecimal.valueOf(1000));
        var card1 = new DebitCard("D1", person1, VISA, LocalDate.of(2025, 1, 1), currentAccount1);
        bank1.addAccount(currentAccount1);
        bank1.addAtm(new Atm("ATM1"));
        bank1.getAtms().getFirst().withdraw(card1, BigDecimal.valueOf(100), EUR);
        log("card1 balance = " + card1.getAvailableBalance() + " " + card1.getCardCurrency());
        log("currentAccount1 balance = " + currentAccount1.getCurrentBalance() + " " + currentAccount1.getBaseCurrency());
        var card2 = new CreditCard("C1", person1, MASTERCARD, LocalDate.of(2024, 1, 1), currentAccount1, BigDecimal.valueOf(100));
        var card2AvailableBalance = card2.getAvailableBalance();
        log("card2 available balance " + card2AvailableBalance + " " + card2.getCardCurrency());
        bank1.getAtms().getFirst().withdraw(card2, card2AvailableBalance, USD);
        log("currentAccount1 balance = " + currentAccount1.getCurrentBalance() + " " + currentAccount1.getBaseCurrency());
        currentAccount1.transfer(BigDecimal.valueOf(200));
        log("added 200 " +currentAccount1.getBaseCurrency() + ", currentAccount1 balance = " + currentAccount1.getCurrentBalance() + " " + currentAccount1.getBaseCurrency());
        var savingAccount1 = new SavingAccount("2", person1, EUR, BigDecimal.valueOf(500), BigDecimal.valueOf(100));
        log("savingAccount1 balance = " + savingAccount1.getCurrentBalance() + " " + savingAccount1.getBaseCurrency());
        savingAccount1.transfer(BigDecimal.valueOf(-50));
        log("-50: savingAccount1 balance = " + savingAccount1.getCurrentBalance() + " " + savingAccount1.getBaseCurrency());
        log("savingAccount1 withdrawal limit = " + savingAccount1.getWithdrawalLimit() + " " + savingAccount1.getBaseCurrency());
        try {
            log("savingAccount1: -100");
            savingAccount1.transfer(BigDecimal.valueOf(-100));
        } catch (Exception e){
            log(e.getMessage());
        }

    }

    public static void log(String message){
        System.getLogger("test").log(System.Logger.Level.INFO, message);
    }
}

