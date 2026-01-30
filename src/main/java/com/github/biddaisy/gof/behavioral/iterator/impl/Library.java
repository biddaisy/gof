package com.mr.gof.behavioral.iterator.impl;

import java.util.ArrayList;
import java.util.List;

import com.mr.gof.behavioral.iterator.Iterator;
import com.mr.gof.behavioral.iterator.Storage;

public class Library<T> implements Storage<T> {

  private final List<T> list;

  public Library() {
    this.list = new ArrayList<>();
  }

  @Override
  public long count() {
    return list.size();
  }

  @Override
  public void add(T e) {
    list.add(e);
  }

  @Override
  public Iterator<T> createIterator() {
    return new LibraryIterator<>(this);
  }

  public T get(int index) {
    return list.get(index);
  }

}
