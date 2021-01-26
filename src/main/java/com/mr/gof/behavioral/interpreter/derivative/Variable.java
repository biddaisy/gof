package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Variable implements Function{

    private final Function derivative = new Constant(BigDecimal.ONE);

    @Override
    public BigDecimal evaluate(Context context) {
        return context.getValue();
    }

    @Override
    public BigDecimal evaluateDerivative(Context context) {
        return derivative.evaluate(context);
    }

    @Override
    public String getFunctionAsFormula(Context context) {
        return context.getName();
    }

    @Override
    public String getDerivativeAsFormula(Context context) {
        return derivative.getFunctionAsFormula(context);
    }

}
