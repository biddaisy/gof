package com.github.biddaisy.gof.behavioral.chain;

public enum CurrencyNote {
  ONE(1),
  TWO(2),
  FIVE(5),
  TEN(10),
  TWENTY(20),
  FIFTY(50),
  HUNDRED(100);

  private final int value;

  CurrencyNote(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
