package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Cosinus implements Function {
  @Override
  public BigDecimal evaluate(Context context) {
    return new BigDecimal(Math.cos(context.getValue().doubleValue()), context.getMathContext());
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return new BigDecimal(-Math.sin(context.getValue().doubleValue()), context.getMathContext());
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return "cos(" + context.getName() + ")";
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return "(-sin(" + context.getName() + "))";
  }

}
