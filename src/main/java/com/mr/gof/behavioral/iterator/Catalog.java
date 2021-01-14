package com.mr.gof.behavioral.iterator;

public interface Catalog<T> {
  long count();

  T get(int index);
}
