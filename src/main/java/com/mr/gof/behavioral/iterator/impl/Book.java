package com.mr.gof.behavioral.iterator.impl;

import java.util.Objects;

public class Book implements Comparable<Book>{

  private final String title;

  public Book(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void print() {
    System.out.println("book '" + title + "'");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Book))
      return false;
    Book book = (Book) o;
    return title.equals(book.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title);
  }

  @Override
  public int compareTo(Book book) {
    return title.compareTo(book.title);
  }
}
