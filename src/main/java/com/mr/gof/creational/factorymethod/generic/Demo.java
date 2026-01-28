package com.mr.gof.creational.factorymethod.generic;

/**
 * Demonstrates the template-style Factory Method in Java.
 */
public class Demo {

    public static void main(String[] args) {

        // Equivalent to: StandardCreator<MyProduct> myCreator;
        Creator creator = new StandardCreator<>(MyProduct.class);

        Product product = creator.createProduct();
        product.execute();
    }
}
