package com.mr.gof.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Library<T> {

  private final List<T> list;

  public Library() {
    this.list = new ArrayList<>();
  }

  public long count() {
    return list.size();
  }

  public T get(int index) {
    return list.get(index);
  }

  public void add(T e){
    list.add(e);
  }

}
