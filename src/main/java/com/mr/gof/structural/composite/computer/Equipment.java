package com.mr.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.util.Iterator;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * Abstract base class representing equipment in the Composite pattern.
 * Defines the common interface for both leaf and composite equipment.
 * Implements the Component role in the Composite pattern.
 *
 * <p>This class provides basic operations for equipment management,
 * including price calculations, power consumption, and equipment traversal.
 * Leaf classes override only the calculation methods, while composite
 * classes also override the equipment management methods.
 *
 * <p>Features:
 * <ul>
 *   <li>Common interface for all equipment types</li>
 *   <li>Default implementations for equipment management (throws exceptions)</li>
 *   <li>Iterator support for equipment traversal</li>
 *   <li>BigDecimal for precise financial calculations</li>
 * </ul>
 *
 * @see CompositeEquipment
 * @see FloppyDisk
 * @see Card
 */
abstract class Equipment {
    protected String name;

    /**
     * Creates new equipment with the specified name.
     *
     * @param name the equipment name
     */
    public Equipment(String name) {
        this.name = name;
    }

    /**
     * Returns the equipment name.
     *
     * @return equipment name
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates the power consumption of this equipment.
     *
     * @return power consumption in watts
     */
    public abstract BigDecimal getPower();

    /**
     * Calculates the net price (without discounts) of this equipment.
     *
     * @return net price in currency units
     */
    public abstract BigDecimal netPrice();

    /**
     * Calculates the discounted price of this equipment.
     *
     * @return discounted price in currency units
     */
    public abstract BigDecimal discountPrice();

    /**
     * Adds child equipment to this equipment.
     * Default implementation throws UnsupportedOperationException
     * since leaf equipment cannot have children.
     *
     * @param equipment child equipment to add
     * @throws UnsupportedOperationException if called on leaf equipment
     */
    public void add(Equipment equipment) {
        throw new UnsupportedOperationException("Cannot add equipment to leaf");
    }

    /**
     * Removes child equipment from this equipment.
     * Default implementation throws UnsupportedOperationException
     * since leaf equipment cannot have children.
     *
     * @param equipment child equipment to remove
     * @throws UnsupportedOperationException if called on leaf equipment
     */
    public void remove(Equipment equipment) {
        throw new UnsupportedOperationException("Cannot remove equipment from leaf");
    }

    /**
     * Creates an iterator for traversing child equipment.
     * Default implementation returns a NullIterator for leaf equipment.
     * Composite equipment should override this to return a proper iterator.
     *
     * @return iterator for child equipment
     * @see NullIterator
     */
    public Iterator<Equipment> createIterator() {
        return new NullIterator();
    }

    /**
     * Returns a string representation of this equipment.
     *
     * @return equipment name
     */
    @Override
    public String toString() {
        return name;
    }
}