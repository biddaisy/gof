package com.mr.gof.behavioral.interpreter.derivative;

public class FunctionDifference implements Function {

  private final Function function1;

  private final Function function2;

  public FunctionDifference(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public String getFunction(String operand) {
    return "(" + function1.getFunction(operand) + " - " + function2.getFunction(operand) + ")";
  }

  @Override
  public String getDerivative(String operand) {
    return "(" + function1.getDerivative(operand) + " - " + function2.getDerivative(operand) + ")";
  }
}
