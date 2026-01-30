package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class FunctionSum implements Function {

  private final Function function1;

  private final Function function2;

  public FunctionSum(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return function1.evaluate(context).add(function2.evaluate(context), context.getMathContext());
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return function1.evaluateDerivative(context).add(function2.evaluateDerivative(context), context.getMathContext());
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return "(" + function1.getFunctionAsFormula(context) + "+" + function2.getFunctionAsFormula(context) + ")";
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return "(" + function1.getDerivativeAsFormula(context) + "+" + function2.getDerivativeAsFormula(context) + ")";
  }

}
