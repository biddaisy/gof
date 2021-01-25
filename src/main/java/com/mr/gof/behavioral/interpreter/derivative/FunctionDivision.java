package com.mr.gof.behavioral.interpreter.derivative;

public class FunctionDivision implements Function {
  private final Function function1;

  private final Function function2;

  public FunctionDivision(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public String getFunction(String operand) {
    return function1.getFunction(operand) + "/" + function2.getFunction(operand);
  }

  @Override
  public String getDerivative(String operand) {
    return getDerivativeFromFunctionMultiplication(operand) + "/" + getOperand2Square(operand);
  }

  private String getDerivativeFromFunctionMultiplication(String operand) {
    return "(" + function1.getDerivative(operand) + function2.getFunction(operand) + " + " + function1.getFunction(operand) + function2.getDerivative(operand)
        + ")";
  }

  private String getOperand2Square(String operand) {
    return function2.getFunction(operand) + "^2";
  }

}
