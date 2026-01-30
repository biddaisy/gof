package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class FunctionMultiplication implements Function {
  private final Function function1;

  private final Function function2;

  public FunctionMultiplication(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return function1.evaluate(context).multiply(function2.evaluate(context), context.getMathContext());
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    if (function1 instanceof Constant)
      return evaluateDerivativeFromConstantAndFunction(context);
    else
      return evaluateDerivativeFromFunctions(context);
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return function1.getFunctionAsFormula(context) + "*" + function2.getFunctionAsFormula(context);
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    if (function1 instanceof Constant)
      return getDerivativeFromConstantAndFunction(context);
    else
      return getDerivativeFromFunctions(context);
  }

  private BigDecimal evaluateDerivativeFromConstantAndFunction(Context context) {
    return function1.evaluate(context).multiply(function2.evaluateDerivative(context), context.getMathContext());
  }

  private BigDecimal evaluateDerivativeFromFunctions(Context context) {
    BigDecimal y1 = function1.evaluateDerivative(context).multiply(function2.evaluate(context));
    BigDecimal y2 = function1.evaluate(context).multiply(function2.evaluateDerivative(context));
    return y1.add(y2, context.getMathContext());
  }

  private String getDerivativeFromConstantAndFunction(Context context) {
    return function1.getFunctionAsFormula(context) + "*" + function2.getDerivativeAsFormula(context);
  }

  private String getDerivativeFromFunctions(Context context) {
    return "(" + function1.getDerivativeAsFormula(context) + "*" + function2.getFunctionAsFormula(context) + " + " + function1.getFunctionAsFormula(context) + "*"
        + function2.getDerivativeAsFormula(context) + ")";
  }
}
