package com.mr.gof.creational.factorymethod.generic;

import com.mr.gof.Logger;

/**
 * Java equivalent of the C++ template-based StandardCreator.
 *
 * The client supplies the product class (T), and this creator
 * instantiates it using reflection. No subclassing required.
 */
public class StandardCreator<T extends Product> implements Creator {

    private final Class<T> productClass;

    /**
     * Constructor receives the class of the product to instantiate.
     */
    public StandardCreator(Class<T> productClass) {
        this.productClass = productClass;
    }

    /**
     * Factory Method.
     *
     * Creates a new instance of T using reflection.
     */
    @Override
    public Product createProduct() {
        try {
            T product = productClass.getDeclaredConstructor().newInstance();
            Logger.log("Created product: " + product.getClass().getSimpleName());
            return product;
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate product: " + productClass.getName(), e);
        }
    }
}
