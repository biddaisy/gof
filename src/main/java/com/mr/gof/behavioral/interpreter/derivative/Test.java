package com.mr.gof.behavioral.interpreter.derivative;

import java.math.BigDecimal;

public class Test {

  public static void main(String... args) {
    Context context = new Context("x", BigDecimal.TEN);
    Function function = new Cosinus();
    print(context, function);
    function = new Sinus();
    print(context, function);
    function = new FunctionMultiplication(new Sinus(), new Cosinus());
    print(context, function);
    function = new FunctionSum(new Sinus(), new Cosinus());
    print(context, function);
    function = new FunctionComposite(new Sinus(), new Cosinus());
    print(context, function);
  }

  private static void print(Context context, Function function) {
    System.out.println();
    System.out.println("f(x) = " + function.getFunctionAsFormula(context));
    System.out.println("f'(x) = " + function.getDerivativeAsFormula(context));
    System.out.println("f(" + context.getValue() + ") = " + function.evaluate(context));
    System.out.println("f'(" + context.getValue() + ") = " + function.evaluateDerivative(context));
  }
}
