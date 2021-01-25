package com.mr.gof.behavioral.interpreter.derivative;

public class Cosinus implements Function {
  @Override
  public String getFunction(String operand) {
    return "cos(" + operand + ")";
  }

  @Override
  public String getDerivative(String operand) {
    return "(-sin(" + operand + "))";
  }
}
