package com.github.biddaisy.gof.structural.adapter.pluggable;

//Adaptee
public class CoffeeMaker {

    public void brew(int quantityMilliliter, int temperature){
        System.out.printf("%d ml coffee of temperature %d degree C%n", quantityMilliliter, temperature);
    }
}
