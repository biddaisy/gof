package com.mr.gof.behavioral.iterator;

import java.util.TreeSet;

public class Catalog<T> {

  private final TreeSet<T> treeSet;

  public Catalog() {
    this.treeSet = new TreeSet<>();
  }

  public long count() {
    return treeSet.size();
  }

  public void add(T e) {
    treeSet.add(e);
  }

  public T[] getAll() {
    return (T[]) treeSet.toArray();
  }

}
