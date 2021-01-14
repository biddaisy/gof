package com.mr.gof.behavioral.iterator;

public interface Iterator<T> {
  void first();

  void next();

  boolean isDone();

  T currentItem();
}
