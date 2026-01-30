package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Concrete composite class representing a computer cabinet/case.
 * Extends CompositeEquipment to provide cabinet-specific pricing.
 *
 * <p>A cabinet is the outermost container that houses all computer
 * components. It typically contains chassis, power supplies, and
 * other major components.
 *
 * <p>Pricing logic:
 * <ul>
 *   <li>Base cabinet price: $300.00</li>
 *   <li>Cabinet discount: 15% off base price</li>
 *   <li>Total price = discounted cabinet price + child equipment prices</li>
 * </ul>
 *
 * @see CompositeEquipment
 * @see Chassis
 * @see Equipment
 */
class Cabinet extends CompositeEquipment {
    private static final BigDecimal CABINET_PRICE = new BigDecimal("300.0");
    private static final BigDecimal CABINET_DISCOUNT = new BigDecimal("0.15");

    /**
     * Creates a new cabinet with the specified name.
     *
     * @param name the cabinet name
     */
    public Cabinet(String name) {
        super(name);
    }

    /**
     * Calculates the net price of this cabinet.
     * Adds the cabinet base price to the total of child equipment.
     *
     * @return cabinet base price + child equipment net prices
     */
    @Override
    public BigDecimal netPrice() {
        return CABINET_PRICE.add(super.netPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the discounted price of this cabinet.
     * Adds the discounted cabinet price to the discounted prices
     * of child equipment.
     *
     * @return discounted cabinet price + child equipment discounted prices
     */
    @Override
    public BigDecimal discountPrice() {
        BigDecimal cabinetDiscounted = CABINET_PRICE.multiply(
                BigDecimal.ONE.subtract(CABINET_DISCOUNT)
        );
        return cabinetDiscounted.add(super.discountPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
