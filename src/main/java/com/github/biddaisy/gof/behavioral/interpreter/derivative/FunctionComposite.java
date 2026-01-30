package com.github.biddaisy.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class FunctionComposite implements Function {
  private final Function function1;

  private final Function function2;

  public FunctionComposite(Function function1, Function function2) {
    this.function1 = function1;
    this.function2 = function2;
  }

  @Override
  public BigDecimal evaluate(Context context) {
    return function1.evaluate(getEnclosingContext(context));
  }

  @Override
  public BigDecimal evaluateDerivative(Context context) {
    return function1.evaluateDerivative(getEnclosingContext(context))
            .multiply(function2.evaluateDerivative(context), context.getMathContext());
  }

  @Override
  public String getFunctionAsFormula(Context context) {
    Context enclosingContext = getEnclosingContext(context);
    return function1.getFunctionAsFormula(enclosingContext);
  }

  @Override
  public String getDerivativeAsFormula(Context context) {
    return function1.getDerivativeAsFormula(getEnclosingContext(context)) + "*" + function2.getDerivativeAsFormula(context);
  }

  private Context getEnclosingContext(Context context) {
    return new Context(function2.getFunctionAsFormula(context), function2.evaluate(context));
  }
}
