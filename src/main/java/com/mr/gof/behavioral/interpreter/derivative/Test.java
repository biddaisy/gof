package com.mr.gof.behavioral.interpreter.derivative;

public class Test {

    public static void main(String... args){
        Function function = new FunctionMultiplication(new Sinus(), new Cosinus());
        System.out.println("f(x) = " + function.getFunction("x"));
        System.out.println("f'(x) = " + function.getDerivative("x"));
        function = new FunctionSum(new Sinus(), new Cosinus());
        System.out.println("f(x) = " + function.getFunction("x"));
        System.out.println("f'(x) = " + function.getDerivative("x"));
        function = new FunctionComposite(new Sinus(), new Cosinus());
        System.out.println("f(x) = " + function.getFunction("x"));
        System.out.println("f'(x) = " + function.getDerivative("x"));

    }
}
