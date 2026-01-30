package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Sinus implements Function {
  @Override
  public BigDecimal evaluate(Context context) {
    return new BigDecimal(Math.sin(context.getValue().doubleValue()), context.getMathContext());
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return new Cosinus().evaluate(context);
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return "sin(" + context.getName() + ")";
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return "cos(" + context.getName() + ")";
  }
}
