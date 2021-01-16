package com.mr.gof.behavioral.iterator;

public interface Storage<T> {
  long count();

  void add(T e);

  Iterator<T> createIterator();
}
