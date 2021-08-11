package com.mr.gof.behavioral.chain;

public class Test {

    public static void main(String... args){
        ATM atm = new ATM();
        atm.dispense(new CurrencyAmount(123));
        atm.dispense(new CurrencyAmount(11));
        atm.dispense(new CurrencyAmount(1053));
    }
}
