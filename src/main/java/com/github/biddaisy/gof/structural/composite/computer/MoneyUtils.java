package com.github.biddaisy.gof.structural.composite.computer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for financial operations and formatting.
 * Provides helper methods for working with monetary values.
 *
 * <p>This class encapsulates common financial operations
 * to ensure consistency and proper rounding throughout the application.
 *
 * <p>Features:
 * <ul>
 *   <li>Currency formatting with proper symbols</li>
 *   <li>Discount calculation with proper rounding</li>
 *   <li>Consistent rounding mode (HALF_UP) for financial calculations</li>
 * </ul>
 */
class MoneyUtils {
    /**
     * Formats a BigDecimal amount as currency.
     * Uses US dollar format with two decimal places.
     *
     * @param amount the amount to format
     * @return formatted currency string (e.g., "$123.45")
     */
    public static String formatCurrency(BigDecimal amount) {
        return String.format("$%.2f", amount);
    }

    /**
     * Calculates the discounted price of an item.
     *
     * @param price the original price
     * @param discountPercent the discount percentage (e.g., 0.15 for 15%)
     * @return discounted price rounded to two decimal places
     */
    public static BigDecimal calculateDiscount(BigDecimal price, BigDecimal discountPercent) {
        return price.multiply(BigDecimal.ONE.subtract(discountPercent))
                .setScale(2, RoundingMode.HALF_UP);
    }
}