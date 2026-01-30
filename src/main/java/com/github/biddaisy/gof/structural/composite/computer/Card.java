package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Leaf class representing an expansion card (e.g., network card, sound card).
 * Implements the Leaf role in the Composite pattern.
 *
 * <p>This class represents a terminal equipment component that provides
 * specific functionality. All calculations are based on fixed constants.
 *
 * <p>Characteristics:
 * <ul>
 *   <li>Fixed base price: $120.00</li>
 *   <li>Fixed power consumption: 25 watts</li>
 *   <li>Fixed discount: 15% off base price</li>
 *   <li>Cannot contain other equipment</li>
 * </ul>
 *
 * @see Equipment
 * @see CompositeEquipment
 */
class Card extends Equipment {
    private static final BigDecimal BASE_POWER = new BigDecimal("25.0");
    private static final BigDecimal BASE_PRICE = new BigDecimal("120.0");
    private static final BigDecimal DISCOUNT = new BigDecimal("0.15");

    /**
     * Creates a new expansion card with the specified name.
     *
     * @param name the card name
     */
    public Card(String name) {
        super(name);
    }

    /**
     * Returns the power consumption of this card.
     *
     * @return 25.0 watts (constant)
     */
    @Override
    public BigDecimal getPower() {
        return BASE_POWER;
    }

    /**
     * Returns the net price of this card.
     *
     * @return $120.00 (constant)
     */
    @Override
    public BigDecimal netPrice() {
        return BASE_PRICE;
    }

    /**
     * Returns the discounted price of this card.
     * Applies a 15% discount to the base price.
     *
     * @return $102.00 (base price minus 15% discount)
     */
    @Override
    public BigDecimal discountPrice() {
        return BASE_PRICE.multiply(BigDecimal.ONE.subtract(DISCOUNT))
                .setScale(2, RoundingMode.HALF_UP);
    }
}