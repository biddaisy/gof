package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Context {

  private String name;

  private BigDecimal value;

  private MathContext mathContext;

  public Context(String name, BigDecimal value) {
    this.name = name;
    this.value = value;
    this.mathContext = new MathContext(2, RoundingMode.HALF_UP);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public void setPrecision(int precision) {
    this.mathContext = new MathContext(precision, RoundingMode.HALF_UP);
  }

  public MathContext getMathContext() {
    return mathContext;
  }
}
