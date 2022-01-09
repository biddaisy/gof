package com.mr.gof.structural.adapter.twoway;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

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

  @Override
  public String toString() {
    return "set = {" + set.stream().sorted().map(String::valueOf).collect(Collectors.joining(",")) + '}';
  }
}
