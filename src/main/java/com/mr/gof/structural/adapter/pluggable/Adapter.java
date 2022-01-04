package com.mr.gof.structural.adapter.pluggable;

import java.util.function.IntConsumer;

//Adapter
public class Adapter extends Beverage {

  private final IntConsumer beverageMaker;

  public Adapter(CoffeeMaker coffeeMaker) {
    beverageMaker = q -> coffeeMaker.brew(q, 90);
  }

  public Adapter(JuiceMaker juiceMaker) {
    beverageMaker = juiceMaker::squeeze;
  }

  @Override
  public void getBeverage(int quantityMilliliter) {
    beverageMaker.accept(quantityMilliliter);
  }
}
