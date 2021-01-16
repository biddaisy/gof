package com.mr.gof.behavioral.iterator;

import com.mr.gof.behavioral.iterator.impl.Book;
import com.mr.gof.behavioral.iterator.impl.Catalog;
import com.mr.gof.behavioral.iterator.impl.Library;

public class Test {

  public static void main(String... args) {
    Library<Book> library = new Library<>();
    library.add(new Book("Book 5"));
    library.add(new Book("Book 4"));
    library.add(new Book("Book 3"));
    library.add(new Book("Book 2"));
    library.add(new Book("Book 1"));
    library.add(new Book("Book 5"));
    library.add(new Book("Book 1"));
    Iterator<Book> libraryIterator = library.createIterator();
    System.out.println("Library:");
    printBooks(libraryIterator);
    Catalog<Book> catalog = createCatalog(library);
    Iterator<Book> catalogIterator = catalog.createIterator();
    System.out.println("Catalog:");
    printBooks(catalogIterator);
  }

  public static void printBooks(Iterator<Book> bookIterator) {
    for (bookIterator.first(); !bookIterator.isDone(); bookIterator.next()) {
      bookIterator.currentItem().print();
    }
  }

  public static Catalog<Book> createCatalog(Library<Book> library) {
    Catalog<Book> catalog = new Catalog<>();
    Iterator<Book> bookLibraryIterator = library.createIterator();
    for (bookLibraryIterator.first(); !bookLibraryIterator.isDone(); bookLibraryIterator.next()) {
      catalog.add(bookLibraryIterator.currentItem());
    }
    return catalog;
  }

}
