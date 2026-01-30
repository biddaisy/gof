package com.mr.gof.behavioral.iterator.impl;

import com.mr.gof.behavioral.iterator.Iterator;

class CatalogIterator<T> implements Iterator<T> {

  private final Catalog<T> catalog;

  private int currentIndex;

  public CatalogIterator(Catalog<T> catalog) {
    this.catalog = catalog;
  }

  @Override
  public void first() {
    currentIndex = 0;
  }

  @Override
  public void next() {
    currentIndex++;
  }

  @Override
  public boolean isDone() {
    return currentIndex >= catalog.count();
  }

  @Override
  public T currentItem() {
    if (isDone()) {
      throw new IndexOutOfBoundsException();
    }
    return catalog.getAll()[currentIndex];
  }
}
