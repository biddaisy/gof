package com.mr.gof.behavioral.interpreter.derivative;

public class Sinus implements Function {
  @Override
  public String getFunction(String operand) {
    return "sin(" + operand + ")";
  }

  @Override
  public String getDerivative(String operand) {
    return "cos(" + operand + ")";
  }
}
