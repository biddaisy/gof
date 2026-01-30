package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public interface Function {

  BigDecimal evaluate(Context context);

  BigDecimal evaluateDerivative(Context context);

  String getFunctionAsFormula(Context context);

  String getDerivativeAsFormula(Context context);

}
