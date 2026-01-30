package com.github.biddaisy.gof.behavioral.interpreter.boolexp;

public class Constant implements BooleanExp {

  private final boolean value;

  public Constant(boolean value) {
    this.value = value;
  }

  @Override
    public boolean evaluate(Context context) {
        return value;
    }

  @Override
  public BooleanExp replace(String name, BooleanExp booleanExp) {
    return new Constant(value);
  }

  @Override
  public BooleanExp copy() {
    return new Constant(value);
  }

  @Override
  public String string() {
    return String.valueOf(value);
  }
}
