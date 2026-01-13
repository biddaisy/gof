package com.mr.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract base class for equipment that can contain other equipment.
 * Implements the Composite role in the Composite pattern.
 *
 * <p>This class provides the infrastructure for managing child equipment
 * and performing aggregate calculations. Subclasses should implement
 * their own pricing logic while leveraging the composite functionality.
 *
 * <p>Key responsibilities:
 * <ul>
 *   <li>Manages a collection of child equipment</li>
 *   <li>Provides implementations for add/remove operations</li>
 *   <li>Aggregates calculations across child equipment</li>
 *   <li>Provides iteration over child equipment</li>
 * </ul>
 *
 * @see Equipment
 * @see Chassis
 * @see Bus
 * @see Cabinet
 */
abstract class CompositeEquipment extends Equipment {
    /**
     * List of child equipment contained in this composite.
     * Uses ArrayList for efficient random access and iteration.
     */
    protected List<Equipment> equipment = new ArrayList<>();

    /**
     * Creates new composite equipment with the specified name.
     *
     * @param name the composite equipment name
     */
    protected CompositeEquipment(String name) {
        super(name);
    }

    /**
     * Adds child equipment to this composite.
     *
     * @param equipment child equipment to add
     */
    @Override
    public void add(Equipment equipment) {
        this.equipment.add(equipment);
    }

    /**
     * Removes child equipment from this composite.
     *
     * @param equipment child equipment to remove
     */
    @Override
    public void remove(Equipment equipment) {
        this.equipment.remove(equipment);
    }

    /**
     * Creates an iterator for traversing child equipment.
     * Returns the standard ArrayList iterator.
     *
     * @return iterator for child equipment
     */
    @Override
    public Iterator<Equipment> createIterator() {
        return equipment.iterator();
    }

    /**
     * Calculates the total power consumption of this composite.
     * Sums the power consumption of all child equipment.
     *
     * @return total power consumption in watts
     */
    @Override
    public BigDecimal getPower() {
        BigDecimal totalPower = BigDecimal.ZERO;
        for (Equipment e : equipment) {
            totalPower = totalPower.add(e.getPower());
        }
        return totalPower.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the net price of this composite.
     * Sums the net prices of all child equipment.
     * Subclasses should override to add their own base price.
     *
     * @return total net price
     */
    @Override
    public BigDecimal netPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Equipment e : equipment) {
            total = total.add(e.netPrice());
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the discounted price of this composite.
     * Sums the discounted prices of all child equipment.
     * Subclasses should override to add their own discounted base price.
     *
     * @return total discounted price
     */
    @Override
    public BigDecimal discountPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Equipment e : equipment) {
            total = total.add(e.discountPrice());
        }
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}