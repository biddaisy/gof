package com.mr.gof.behavioral.iterator;

import com.mr.gof.behavioral.iterator.impl.*;

public class Test {

  public static void main(String... args) {
    Library<Book> library = new Library<>();
    library.add(new Book("Book 5", "Author 5"));
    library.add(new Book("Book 4", "Author 4"));
    library.add(new Book("Book 3", "Author 3"));
    library.add(new Book("Book 2", "Author 2"));
    library.add(new Book("Book 1", "Author 1"));
    library.add(new Book("Book 5", "Author 5"));
    library.add(new Book("Book 1", "Author 1"));
    Iterator<Book> libraryIterator = library.createIterator();
    System.out.println("Library:");
    printBooks(libraryIterator);
    Catalog<Book> catalog = createCatalog(library);
    Iterator<Book> catalogIterator = catalog.createIterator();
    System.out.println("Catalog:");
    printBooks(catalogIterator);
    System.out.println("Traverse library:");
    boolean traversedAll = new PrintNBooks(library, 8).traverse();
    System.out.println("Traversed all " + traversedAll);
    System.out.println("Traverse catalog:");
    traversedAll = new PrintNBooks(catalog, 2).traverse();
    System.out.println("Traversed all " + traversedAll);

    System.out.println("Traverse library by Author 5:");
    new PrintAuthorBooks(library, "Author 5").traverse();
    System.out.println("Traverse catalog by Author 5:");
    new PrintAuthorBooks(catalog, "Author 5").traverse();
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
