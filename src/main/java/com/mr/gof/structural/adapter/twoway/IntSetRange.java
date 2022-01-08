package com.mr.gof.structural.adapter.twoway;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class IntSetRange implements IntSet, IntRange{

    private final IntRange intRange;

    public IntSetRange() {
        this.intRange = new IntRangeImpl();
    }

    public IntSetRange(IntRange intRange) {
        this.intRange = Objects.requireNonNull(intRange);
    }

    @Override
    public void unionWith(IntRange other) {
        this.intRange.unionWith(other);
    }

    @Override
    public void differenceFrom(IntRange other) {
        this.intRange.differenceFrom(other);
    }

    @Override
    public boolean isSupersetOf(IntRange other) {
        return this.intRange.isSupersetOf(other);
    }

    @Override
    public List<Integer> asList() {
        return this.intRange.asList();
    }

    @Override
    public void add(int value) {
        this.intRange.unionWith(IntRangeImpl.singleton(value));
    }

    @Override
    public void remove(int value) {
        this.differenceFrom(IntRangeImpl.singleton(value));
    }

    @Override
    public boolean member(int value) {
        return this.isSupersetOf(IntRangeImpl.singleton(value));
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.asList().iterator();
    }
}
