package com.mr.gof.behavioral.interpreter.boolexp;

public class VariableExp implements BooleanExp {

  private final String name;

  public VariableExp(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean evaluate(Context context) {
    return context.lookup(name);
  }

  @Override
  public BooleanExp replace(String name, BooleanExp booleanExp) {
    if (this.name.equals(name)) {
      return booleanExp.copy();
    }
    else {
      return new VariableExp(this.name);
    }
  }

  @Override
  public BooleanExp copy() {
    return new VariableExp(name);
  }

  @Override
  public String string() {
    return name;
  }
}
