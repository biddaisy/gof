package com.mr.gof.behavioral.iterator.impl;

import com.mr.gof.behavioral.iterator.Book;
import com.mr.gof.behavioral.iterator.Catalog;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog implements Catalog<Book> {

  private final List<Book> books;

  public BookCatalog(List<Book> books) {
    this.books = new ArrayList<>(books);
  }

  @Override
  public long count() {
    return books.size();
  }

  @Override
  public Book get(int index) {
    return books.get(index);
  }
}
