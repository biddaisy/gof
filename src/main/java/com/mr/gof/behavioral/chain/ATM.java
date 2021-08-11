package com.mr.gof.behavioral.chain;

public class ATM {

  private Dispenser dispenser;

  public ATM() {
    Dispenser dispenser1 = new Dispenser(null, CurrencyNote.ONE);
    Dispenser dispenser2 = new Dispenser(dispenser1, CurrencyNote.TWO);
    Dispenser dispenser5 = new Dispenser(dispenser2, CurrencyNote.FIVE);
    Dispenser dispenser10 = new Dispenser(dispenser5, CurrencyNote.TEN);
    Dispenser dispenser20 = new Dispenser(dispenser10, CurrencyNote.TWENTY);
    Dispenser dispenser50 = new Dispenser(dispenser20, CurrencyNote.FIFTY);
    dispenser = new Dispenser(dispenser50, CurrencyNote.HUNDRED);
  }

  public void dispense(CurrencyAmount currencyAmount) {
    System.out.printf("Dispensing amount is %d$ :%n", currencyAmount.getAmount());
    dispenser.dispense(currencyAmount);
  }
}
