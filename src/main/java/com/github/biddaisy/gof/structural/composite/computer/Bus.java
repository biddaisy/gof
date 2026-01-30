package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Concrete composite class representing an expansion bus.
 * Extends CompositeEquipment to provide bus-specific pricing.
 *
 * <p>A bus is equipment that contains expansion cards. It provides
 * connectivity between the motherboard and expansion cards.
 *
 * <p>Pricing logic:
 * <ul>
 *   <li>Base bus price: $150.00</li>
 *   <li>Bus discount: 5% off base price</li>
 *   <li>Total price = discounted bus price + child card prices</li>
 * </ul>
 *
 * @see CompositeEquipment
 * @see Card
 * @see Equipment
 */
class Bus extends CompositeEquipment {
    private static final BigDecimal BUS_PRICE = new BigDecimal("150.0");
    private static final BigDecimal BUS_DISCOUNT = new BigDecimal("0.05");

    /**
     * Creates a new bus with the specified name.
     *
     * @param name the bus name
     */
    public Bus(String name) {
        super(name);
    }

    /**
     * Calculates the net price of this bus.
     * Adds the bus base price to the total of child equipment.
     *
     * @return bus base price + child equipment net prices
     */
    @Override
    public BigDecimal netPrice() {
        return BUS_PRICE.add(super.netPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the discounted price of this bus.
     * Adds the discounted bus price to the discounted prices
     * of child equipment.
     *
     * @return discounted bus price + child equipment discounted prices
     */
    @Override
    public BigDecimal discountPrice() {
        BigDecimal busDiscounted = BUS_PRICE.multiply(
                BigDecimal.ONE.subtract(BUS_DISCOUNT)
        );
        return busDiscounted.add(super.discountPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }
}