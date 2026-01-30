package com.github.biddaisy.gof.behavioral.iterator.impl;

import com.github.biddaisy.gof.behavioral.iterator.Storage;
import com.github.biddaisy.gof.behavioral.iterator.Traverser;

public class PrintNBooks extends Traverser<Book> {

  private final int total;

  private int count;

  public PrintNBooks(Storage<Book> books, int n) {
    super(books);
    this.count = 0;
    this.total = n;
  }

  @Override
  protected boolean process(Book book) {
    count++;
    book.print();
    return count < total;
  }
}
