package com.mr.gof.structural.adapter.twoway;

import java.util.List;

public interface IntRange {
    /**
     * Inserts the elements of {@code other} into this set.
     */
    void unionWith(IntRange other);

    /**
     * Removes the elements of {@code other} from this set.
     */
    void differenceFrom(IntRange other);

    /**
     * Checks whether this set is a superset of the {@code other} set.
     */
    boolean isSupersetOf(IntRange other);

    /**
     * The contents of the set as a list of integers. Modifying the returned
     * list will have no effect on this set.
     */
    List<Integer> asList();
}
