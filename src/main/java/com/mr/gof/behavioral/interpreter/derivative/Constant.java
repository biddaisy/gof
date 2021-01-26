package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Constant implements Function {

  private final BigDecimal number;

  private final Function derivative = new Constant(BigDecimal.ZERO);

  public Constant(BigDecimal number) {
    this.number = number;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return number;
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return derivative.evaluate(context);
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return number.toPlainString();
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return derivative.getFunctionAsFormula(context);
  }

}
