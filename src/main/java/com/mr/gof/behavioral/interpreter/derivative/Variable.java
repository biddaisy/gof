package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Variable implements Function{

    private final Function derivative = new Constant(BigDecimal.ONE);

    @Override
    public String getFunction(String operand) {
        return "x";
    }

    @Override
    public String getDerivative(String operand) {
        return derivative.getFunction(operand);
    }

}
