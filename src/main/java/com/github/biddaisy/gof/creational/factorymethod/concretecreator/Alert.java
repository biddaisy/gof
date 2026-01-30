package com.github.biddaisy.gof.creational.factorymethod.concretecreator;

/**
 * Product interface for alert types.
 */
public interface Alert {
    void trigger(String message);
}
