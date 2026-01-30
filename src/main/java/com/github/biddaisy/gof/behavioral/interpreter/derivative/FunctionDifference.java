package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class FunctionDifference implements Function {

  private final Function function1;

  private final Function function2;

  public FunctionDifference(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return function1.evaluate(context).subtract(function2.evaluate(context));
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return function1.evaluate(context).subtract(function2.evaluate(context));
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return "(" + function1.getFunctionAsFormula(context) + " - " + function2.getFunctionAsFormula(context) + ")";
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return "(" + function1.getDerivativeAsFormula(context) + " - " + function2.getDerivativeAsFormula(context) + ")";
  }
}
