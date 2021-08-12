package com.mr.gof.behavioral.chain;

public class Test {

    public static void main(String... args) {
        Atm atm = new Atm(CurrencyNote.values());
        try {
            atm.dispense(new CurrencyAmount(123));
        } catch (DispensingException e) {
            printDispensingError(atm, 123);
        }
        try {
            atm.dispense(new CurrencyAmount(11));
        } catch (DispensingException e) {
            printDispensingError(atm, 11);
        }
        try {
            atm.dispense(new CurrencyAmount(1053));
        } catch (DispensingException e) {
            printDispensingError(atm, 1053);
        }
        atm = new Atm(CurrencyNote.FIVE, CurrencyNote.TEN);
        try {
            atm.dispense(new CurrencyAmount(123));
        } catch (DispensingException e) {
            printDispensingError(atm, 123);
        }
        try {
            atm.dispense(new CurrencyAmount(15));
        } catch (DispensingException e) {
            printDispensingError(atm, 15);
        }
    }

    private static void printDispensingError(Atm atm, int amount){
        System.out.printf("No notes to dispense %d%n", amount);
        System.out.printf("Available notes : %s%n", atm.getAvailableCurrencyNotesAsString());
    }
}
