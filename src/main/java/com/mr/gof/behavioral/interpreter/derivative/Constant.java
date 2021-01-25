package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Constant implements Function{

    private final BigDecimal number;
    private final Function derivative = new Constant(BigDecimal.ZERO);

    public Constant(BigDecimal number) {
        this.number = number;
    }

    @Override
    public String getFunction(String operand) {
        return number.toPlainString();
    }

    @Override
    public String getDerivative(String operand) {
        return derivative.getFunction(operand);
    }

}
