package com.github.biddaisy.gof.behavioral.iterator.impl;

import com.github.biddaisy.gof.Logger;

import java.util.Objects;

public class Book implements Comparable<Book> {

  private final String title;

  private final String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void print() {
    Logger.log("book '" + title + "' author " + author);
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
