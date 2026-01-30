package com.mr.gof.behavioral.iterator.impl;

import com.mr.gof.behavioral.iterator.FilteringTraverser;
import com.mr.gof.behavioral.iterator.Storage;

public class PrintAuthorBooks extends FilteringTraverser<Book> {

  private final String author;

  public PrintAuthorBooks(Storage<Book> books, String author) {
    super(books);
    this.author = author;
  }

  @Override
  protected boolean test(Book book) {
    return book.getAuthor().equalsIgnoreCase(author);
  }

  @Override
  protected boolean process(Book book) {
    book.print();
    return true;
  }
}
