package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Constant implements Function {

  private final BigDecimal number;

  public Constant(BigDecimal number) {
    this.number = number;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return number;
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return BigDecimal.ZERO;
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    return number.toPlainString();
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return BigDecimal.ZERO.toPlainString();
  }

}
