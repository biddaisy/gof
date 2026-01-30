package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Leaf class representing a floppy disk drive.
 * Implements the Leaf role in the Composite pattern.
 *
 * <p>This class represents a terminal equipment component that cannot
 * contain other equipment. All calculations are based on fixed constants.
 *
 * <p>Characteristics:
 * <ul>
 *   <li>Fixed base price: $50.00</li>
 *   <li>Fixed power consumption: 15 watts</li>
 *   <li>Fixed discount: 10% off base price</li>
 *   <li>Cannot contain other equipment</li>
 * </ul>
 *
 * @see Equipment
 * @see CompositeEquipment
 */
class FloppyDisk extends Equipment {
    private static final BigDecimal BASE_POWER = new BigDecimal("15.0");
    private static final BigDecimal BASE_PRICE = new BigDecimal("50.0");
    private static final BigDecimal DISCOUNT = new BigDecimal("0.10");

    /**
     * Creates a new floppy disk with the specified name.
     *
     * @param name the floppy disk name
     */
    public FloppyDisk(String name) {
        super(name);
    }

    /**
     * Returns the power consumption of this floppy disk.
     *
     * @return 15.0 watts (constant)
     */
    @Override
    public BigDecimal getPower() {
        return BASE_POWER;
    }

    /**
     * Returns the net price of this floppy disk.
     *
     * @return $50.00 (constant)
     */
    @Override
    public BigDecimal netPrice() {
        return BASE_PRICE;
    }

    /**
     * Returns the discounted price of this floppy disk.
     * Applies a 10% discount to the base price.
     *
     * @return $45.00 (base price minus 10% discount)
     */
    @Override
    public BigDecimal discountPrice() {
        return BASE_PRICE.multiply(BigDecimal.ONE.subtract(DISCOUNT))
                .setScale(2, RoundingMode.HALF_UP);
    }
}