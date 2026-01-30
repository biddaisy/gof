package com.github.biddaisy.gof.behavioral.chain;

public class Dispenser {

  private final Dispenser nextDispenser;

  private final CurrencyNote currencyNote;

  public Dispenser(Dispenser nextDispenser, CurrencyNote currencyNote) {
    this.nextDispenser = nextDispenser;
    this.currencyNote = currencyNote;
  }

  public void dispense(CurrencyAmount currencyAmount) throws DispensingException {
    int noteValue = currencyNote.getValue();
    if (currencyAmount.getAmount() >= noteValue) {
      int num = currencyAmount.getAmount() / noteValue;
      int remainder = currencyAmount.getAmount() % noteValue;
      System.out.printf("Dispensing %d x %d$ note%n", num, noteValue);
      if (remainder != 0 && hasNextDispenser())
        nextDispenser.dispense(new CurrencyAmount(remainder));
      else if (remainder != 0)
        throw new DispensingException(String.format("no notes to dispense remaining amount %d", remainder));
    }
    else {
      if (!hasNextDispenser())
        throw new DispensingException(String.format("no notes to dispense remaining amount %d", currencyAmount.getAmount()));
      nextDispenser.dispense(currencyAmount);
    }
  }

  public CurrencyNote getCurrencyNote() {
    return currencyNote;
  }

  public Dispenser getNextDispenser() {
    return nextDispenser;
  }

  private boolean hasNextDispenser() {
    return nextDispenser != null;
  }

}
