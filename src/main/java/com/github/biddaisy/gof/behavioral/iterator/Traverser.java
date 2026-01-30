package com.github.biddaisy.gof.behavioral.iterator;

public abstract class Traverser<T> {
  private final Iterator<T> iterator;

  protected Traverser(Storage<T> storage) {
    this.iterator = storage.createIterator();
  }

  public boolean traverse(){
    boolean result = false;
    for (iterator.first(); !iterator.isDone(); iterator.next()) {
      result = process(iterator.currentItem());
      if (!result) {
        break;
      }
    }
    return result;
  }

  protected abstract boolean process(T currentItem);
}
