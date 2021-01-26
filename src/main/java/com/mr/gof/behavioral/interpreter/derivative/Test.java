package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Test {

  public static void main(String... args) {
    Context context = new Context("x", BigDecimal.TEN);
    print(context, new Constant(BigDecimal.ONE));
    print(context, new Variable());
    print(context, new Cosinus());
    print(context, new Sinus());
    print(context, new FunctionMultiplication(new Sinus(), new Cosinus()));
    print(context, new FunctionDivision(new Sinus(), new Cosinus()));
    print(context, new FunctionSum(new Sinus(), new Cosinus()));
    print(context, new FunctionDifference(new Sinus(), new Cosinus()));
    print(context, new FunctionComposite(new Sinus(), new Cosinus()));
    print(context, new FunctionComposite(new FunctionSum(new Sinus(), new Cosinus()), new Cosinus()));
    print(context, new FunctionMultiplication(new Constant(BigDecimal.TEN),
            new FunctionDifference(new Constant(BigDecimal.valueOf(1.23)), new Variable())));
  }

  private static void print(Context context, Function function) {
    System.out.println();
    System.out.println("f(x) = " + function.getFunctionAsFormula(context));
    System.out.println("f'(x) = " + function.getDerivativeAsFormula(context));
    System.out.println("f(" + context.getValue() + ") = " + function.evaluate(context));
    System.out.println("f'(" + context.getValue() + ") = " + function.evaluateDerivative(context));
  }
}
