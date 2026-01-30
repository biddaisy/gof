package com.github.biddaisy.gof.behavioral.iterator.impl;

import com.github.biddaisy.gof.behavioral.iterator.FilteringTraverser;
import com.github.biddaisy.gof.behavioral.iterator.Storage;

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
