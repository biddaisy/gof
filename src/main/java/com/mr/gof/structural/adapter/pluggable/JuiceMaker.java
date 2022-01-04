package com.mr.gof.structural.adapter.pluggable;

//Adaptee
public class JuiceMaker {
    public void squeeze(int quantityMilliliter){
        System.out.printf("%d ml juice%n", quantityMilliliter);
    }
}
