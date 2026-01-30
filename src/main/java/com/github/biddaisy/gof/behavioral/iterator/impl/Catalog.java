package com.github.biddaisy.gof.behavioral.iterator.impl;

import java.util.TreeSet;

import com.github.biddaisy.gof.behavioral.iterator.Iterator;
import com.github.biddaisy.gof.behavioral.iterator.Storage;

public class Catalog<T> implements Storage<T> {

  private final TreeSet<T> treeSet;

  public Catalog() {
    this.treeSet = new TreeSet<>();
  }

  @Override
  public long count() {
    return treeSet.size();
  }

  @Override
  public void add(T e) {
    treeSet.add(e);
  }

  @Override
  public Iterator<T> createIterator() {
    return new CatalogIterator<>(this);
  }

  public T[] getAll() {
    return (T[]) treeSet.toArray();
  }

}
