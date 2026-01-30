package com.github.biddaisy.gof.behavioral.iterator;

public abstract class FilteringTraverser<T> {

  private final Iterator<T> iterator;

  protected FilteringTraverser(Storage<T> storage) {
    this.iterator = storage.createIterator();
  }

  public boolean traverse(){
    boolean result = false;
    for (iterator.first(); !iterator.isDone(); iterator.next()) {
      if (test(iterator.currentItem())) {
        result = process(iterator.currentItem());
        if (!result) {
          break;
        }
      }
    }
    return result;
  }

  protected abstract boolean test(T item);

  protected abstract boolean process(T item);
}
