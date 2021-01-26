package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class FunctionDivision implements Function {
  private final Function function1;

  private final Function function2;

  public FunctionDivision(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return function1.evaluate(context).divide(function2.evaluate(context), context.getMathContext());
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    BigDecimal z1 = function1.evaluateDerivative(context).multiply(function2.evaluate(context));
    BigDecimal z2 = function1.evaluate(context).multiply(function2.evaluateDerivative(context));
    BigDecimal y1 = z1.add(z2);
    BigDecimal y2 = BigDecimal.valueOf(Math.sqrt(function2.evaluate(context).doubleValue()));
    return y1.divide(y2, context.getMathContext());
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return function1.getFunctionAsFormula(context) + "/" + function2.getFunctionAsFormula(context);
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return getDerivativeFromFunctionMultiplication(context) + "/" + getOperand2Square(context);
  }

  private String getDerivativeFromFunctionMultiplication(Context context) {
    return "(" + function1.getDerivativeAsFormula(context) + function2.getFunctionAsFormula(context) + " + " + function1.getFunctionAsFormula(context) + function2.getDerivativeAsFormula(context)
        + ")";
  }

  private String getOperand2Square(Context context) {
    return function2.getFunctionAsFormula(context) + "^2";
  }

}
