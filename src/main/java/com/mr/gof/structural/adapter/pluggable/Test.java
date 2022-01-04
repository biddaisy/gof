package com.mr.gof.structural.adapter.pluggable;

public class Test {
  // Client
  public static void main(String... args) {
    Adapter coffeeMachine = new Adapter(new CoffeeMaker());
    coffeeMachine.getBeverage(30);

    Adapter juicer = new Adapter(new JuiceMaker());
    juicer.getBeverage(40);
  }
}
