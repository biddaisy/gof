package com.mr.gof.behavioral.chain;

public class Dispenser {

  private final Dispenser nextDispenser;

  private final CurrencyNote currencyNote;

  public Dispenser(Dispenser nextDispenser, CurrencyNote currencyNote) {
    this.nextDispenser = nextDispenser;
    this.currencyNote = currencyNote;
  }

  public void dispense(CurrencyAmount currencyAmount) {
    int noteValue = currencyNote.getValue();
    if (currencyAmount.getAmount() >= noteValue) {
      int num = currencyAmount.getAmount() / noteValue;
      int remainder = currencyAmount.getAmount() % noteValue;
      System.out.printf("Dispensing %d x %d$ note%n", num, noteValue);
      if (remainder != 0)
        nextDispenser.dispense(new CurrencyAmount(remainder));
    }
    else {
      nextDispenser.dispense(currencyAmount);
    }
  }

}
