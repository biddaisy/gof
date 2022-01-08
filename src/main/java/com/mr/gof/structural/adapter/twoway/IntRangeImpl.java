package com.mr.gof.structural.adapter.twoway;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IntRangeImpl implements IntRange {

  private final IntSet set = new IntSetImpl();

  /** Creates a new, empty integer set. */
  public static IntRange empty() {
    return new IntRangeImpl();
  }

  /** Creates a new, singleton integer set with the given member. */
  public static IntRange singleton(int member) {
    IntRange intRange = new IntRangeImpl();
    intRange.asList().add(member);
    return intRange;
  }

  @Override
  public void unionWith(IntRange other) {
    other.asList().forEach(set::add);
  }

  @Override
  public void differenceFrom(IntRange other) {
    other.asList().forEach(set::remove);
  }

  @Override
  public boolean isSupersetOf(IntRange other) {
    for (Integer i : other.asList()) {
      if (!set.member(i))
        return false;
    }
    return true;
  }

  @Override
  public List<Integer> asList() {
    return StreamSupport.stream(set.spliterator(), false).collect(Collectors.toList());
  }
}
