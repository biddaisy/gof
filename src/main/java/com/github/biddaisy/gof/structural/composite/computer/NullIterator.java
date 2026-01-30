package com.github.biddaisy.gof.structural.composite.computer;

import java.util.Iterator;

/**
 * Null Object pattern implementation for equipment iteration.
 * Provides a safe, no-op iterator for leaf equipment.
 *
 * <p>This iterator always returns false for hasNext() and null for next(),
 * preventing NullPointerExceptions when iterating over leaf equipment
 * that has no children.
 *
 * <p>Benefits:
 * <ul>
 *   <li>Eliminates null checks in client code</li>
 *   <li>Provides consistent behavior for all equipment types</li>
 *   <li>Simplifies traversal logic</li>
 * </ul>
 *
 * @see Iterator
 * @see Equipment
 */
class NullIterator implements Iterator<Equipment> {
    /**
     * Always returns false since there are no elements to iterate.
     *
     * @return false
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * Always returns null since there are no elements.
     *
     * @return null
     */
    @Override
    public Equipment next() {
        return null;
    }
}