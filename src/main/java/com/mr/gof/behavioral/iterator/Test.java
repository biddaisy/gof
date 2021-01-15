package com.mr.gof.behavioral.iterator;

import com.mr.gof.behavioral.iterator.impl.LibraryIterator;

import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String... args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book 1"));
    books.add(new Book("Book 2"));
    books.add(new Book("Book 3"));
    books.add(new Book("Book 4"));
    books.add(new Book("Book 5"));
    Library<Book> library = new Library<>(books);
    LibraryIterator<Book> bookLibraryIterator = new LibraryIterator<>(library);
    printBooks(bookLibraryIterator);
  }

  public static void printBooks(Iterator<Book> bookIterator) {
    for (bookIterator.first(); !bookIterator.isDone(); bookIterator.next()) {
      bookIterator.currentItem().print();
    }
  }
}
