package com.github.biddaisy.gof.structural.adapter.pluggable;

//Adapter
public class Adapter extends Beverage {

  private final BeverageMaker beverageMaker;

  public Adapter(CoffeeMaker coffeeMaker) {
    beverageMaker = q -> coffeeMaker.brew(q, 90);
  }

  public Adapter(JuiceMaker juiceMaker) {
    beverageMaker = juiceMaker::squeeze;
  }

  @Override
  public void getBeverage(int quantityMilliliter) {
    beverageMaker.make(quantityMilliliter);
  }
}

@FunctionalInterface
interface BeverageMaker {
  void make(int quantityMilliliter);
}
