package com.github.biddaisy.gof.structural.adapter.twoway;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//object adapter
public class IntRangeImpl implements IntRange {

  private final IntSet adaptee;

  /** Creates a new, empty integer set. */
  public static IntRange empty() {
    return new IntRangeImpl();
  }

  /** Creates a new, singleton integer set with the given member. */
  public static IntRange singleton(int member) {
    return new IntRangeImpl(member);
  }

  public IntRangeImpl() {
    this.adaptee = new IntSetImpl();
  }

  public IntRangeImpl(int... ints) {
    this();
    Arrays.stream(ints).forEach(adaptee::add);
  }

  public IntRangeImpl(IntSet adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void unionWith(IntRange other) {
    other.asList().forEach(adaptee::add);
  }

  @Override
  public void differenceFrom(IntRange other) {
    other.asList().forEach(adaptee::remove);
  }

  @Override
  public boolean isSupersetOf(IntRange other) {
    for (Integer i : other.asList()) {
      if (!adaptee.member(i))
        return false;
    }
    return true;
  }

  @Override
  public List<Integer> asList() {
    return StreamSupport.stream(adaptee.spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return adaptee.toString();
  }
}
