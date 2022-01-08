package com.mr.gof.structural.adapter.twoway;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntSetImpl implements IntSet {

  private final Set<Integer> set = new HashSet<>();

  @Override
  public void add(int value) {
    set.add(value);
  }

  @Override
  public void remove(int value) {
    set.remove(value);
  }

  @Override
  public boolean member(int value) {
    return set.contains(value);
  }

  @Override
  public Iterator<Integer> iterator() {
    return set.iterator();
  }

}
