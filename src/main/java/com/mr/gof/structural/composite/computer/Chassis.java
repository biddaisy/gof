package com.mr.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Concrete composite class representing a computer chassis.
 * Extends CompositeEquipment to provide chassis-specific pricing.
 *
 * <p>A chassis is equipment that contains other equipment like
 * buses, cards, and drives. It has its own base price that is
 * added to the total of contained equipment.
 *
 * <p>Pricing logic:
 * <ul>
 *   <li>Base chassis price: $200.00</li>
 *   <li>Chassis discount: 10% off base price</li>
 *   <li>Total price = discounted chassis price + child equipment prices</li>
 * </ul>
 *
 * @see CompositeEquipment
 * @see Equipment
 */
class Chassis extends CompositeEquipment {
    private static final BigDecimal CHASSIS_PRICE = new BigDecimal("200.0");
    private static final BigDecimal CHASSIS_DISCOUNT = new BigDecimal("0.10");

    /**
     * Creates a new chassis with the specified name.
     *
     * @param name the chassis name
     */
    public Chassis(String name) {
        super(name);
    }

    /**
     * Calculates the net price of this chassis.
     * Adds the chassis base price to the total of child equipment.
     *
     * @return chassis base price + child equipment net prices
     */
    @Override
    public BigDecimal netPrice() {
        return CHASSIS_PRICE.add(super.netPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the discounted price of this chassis.
     * Adds the discounted chassis price to the discounted prices
     * of child equipment.
     *
     * @return discounted chassis price + child equipment discounted prices
     */
    @Override
    public BigDecimal discountPrice() {
        BigDecimal chassisDiscounted = CHASSIS_PRICE.multiply(
                BigDecimal.ONE.subtract(CHASSIS_DISCOUNT)
        );
        return chassisDiscounted.add(super.discountPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }
}