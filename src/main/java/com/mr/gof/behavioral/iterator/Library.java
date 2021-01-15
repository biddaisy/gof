package com.mr.gof.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Library<T> {

  private final List<T> list;

  public Library(List<T> list) {
    this.list = new ArrayList<>(list);
  }

  public long count() {
    return list.size();
  }

  public T get(int index) {
    return list.get(index);
  }
}
