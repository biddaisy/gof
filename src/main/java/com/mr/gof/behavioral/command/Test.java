package com.mr.gof.behavioral.command;

public class Test {

  public static void main(String[] args) {
    Application application = new Application();
    Document document1 = new Document("Test doc 1", "Test text 1");
    Document document2 = new Document("Test doc 2", "Test text 2");
    MenuItem openDocumentMenuItem = new MenuItem(new OpenCommand(application, document1));
    MenuItem copyDocumentMenuItem = new MenuItem(new CopyCommand(application, document2));
    MenuItem pasteDocumentMenuItem = new MenuItem(new PasteCommand(application));
    MenuItem displayDocument = new MenuItem(new SimpleCommand(() -> System.out.println(application.getDocument().getText())));

    openDocumentMenuItem.click();
    copyDocumentMenuItem.click();
    pasteDocumentMenuItem.click();
    displayDocument.click();
  }
}
