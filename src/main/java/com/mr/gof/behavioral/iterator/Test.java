package com.mr.gof.behavioral.iterator;

import com.mr.gof.behavioral.iterator.impl.CatalogIterator;
import com.mr.gof.behavioral.iterator.impl.LibraryIterator;

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
    LibraryIterator<Book> libraryIterator = new LibraryIterator<>(library);
    System.out.println("Library:");
    printBooks(libraryIterator);
    Catalog<Book> catalog = createCatalog(library);
    CatalogIterator<Book> catalogIterator = new CatalogIterator<>(catalog);
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
    LibraryIterator<Book> bookLibraryIterator = new LibraryIterator<>(library);
    for (bookLibraryIterator.first(); !bookLibraryIterator.isDone(); bookLibraryIterator.next()) {
      catalog.add(bookLibraryIterator.currentItem());
    }
    return catalog;
  }

}
