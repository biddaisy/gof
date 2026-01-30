package com.github.biddaisy.gof.behavioral.chain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Atm {

  private Dispenser dispenser;

  private final List<CurrencyNote> availableCurrencyNotes;

  public Atm(CurrencyNote... currencyNotes) {
    availableCurrencyNotes = Arrays.asList(currencyNotes);
    Collections.sort(availableCurrencyNotes);
    Dispenser nextDispenser = null;
    for (CurrencyNote currencyNote : availableCurrencyNotes) {
      dispenser = new Dispenser(nextDispenser, currencyNote);
      nextDispenser = dispenser;
    }
  }

  public void dispense(CurrencyAmount currencyAmount) throws DispensingException {
    System.out.printf("Dispensing amount is %d$ :%n", currencyAmount.getAmount());
    dispenser.dispense(currencyAmount);
  }

  public List<CurrencyNote> getAvailableCurrencyNotes() {
    return availableCurrencyNotes;
  }

  public String getAvailableCurrencyNotesAsString() {
    return Arrays.toString(availableCurrencyNotes.toArray());
  }
}
