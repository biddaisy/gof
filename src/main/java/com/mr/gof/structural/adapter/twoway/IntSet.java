package com.mr.gof.structural.adapter.twoway;

import java.util.Iterator;

public interface IntSet extends Iterable<Integer>{

    /**
     * Adds the given value to this set.
     */
    void add(int value);

    /**
     * Removes the given value from this set, if present.
     */
    void remove(int value);

    /*
     * Determines whether a particular integer value is a member of this set.
     */
    boolean member(int value);

    /**
     * Returns an iterator over the elements.
     */
    Iterator<Integer> iterator();
}
