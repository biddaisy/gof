package com.github.biddaisy.gof.behavioral.iterator.impl;

import com.github.biddaisy.gof.behavioral.iterator.Iterator;

class LibraryIterator<T> implements Iterator<T> {

  private final Library<T> library;

  private int currentIndex;

  public LibraryIterator(Library<T> library) {
    this.library = library;
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
    return currentIndex >= library.count();
  }

  @Override
  public T currentItem() {
    if (isDone()) {
      throw new IndexOutOfBoundsException();
    }
    return library.get(currentIndex);
  }
}
