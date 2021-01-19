package com.mr.gof.behavioral.interpreter.boolexp;

public class NotExp implements BooleanExp {

  private final BooleanExp operand;

  public NotExp(BooleanExp operand) {
    this.operand = operand;
  }

  @Override
  public boolean evaluate(Context context) {
    return !operand.evaluate(context);
  }

  @Override
  public BooleanExp replace(String name, BooleanExp booleanExp) {
    return new NotExp(operand.replace(name, booleanExp));
  }

  @Override
  public BooleanExp copy() {
    return new NotExp(operand.copy());
  }
}
