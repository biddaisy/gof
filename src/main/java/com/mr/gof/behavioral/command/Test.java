package com.mr.gof.behavioral.command;

import com.mr.gof.Logger;

public class Test {

  public static void main(String[] args) {
    Application application = new Application();
    Document document1 = new Document("Test doc 1", "Test text 1");
    Document document2 = new Document("Test doc 2", "Test text 2");
    OpenCommand openCommand = new OpenCommand(application, document1);
    CopyCommand copyCommand = new CopyCommand(application, document2);
    PasteCommand pasteCommand = new PasteCommand(application);
    SimpleCommand simpleCommand = new SimpleCommand(() -> Logger.log(application.getDocument().getText()));

    MenuItem openDocumentMenuItem = new MenuItem(openCommand);
    MenuItem copyDocumentMenuItem = new MenuItem(copyCommand);
    MenuItem pasteDocumentMenuItem = new MenuItem(pasteCommand);
    MenuItem displayDocument = new MenuItem(simpleCommand);

    openDocumentMenuItem.click();
    copyDocumentMenuItem.click();
    pasteDocumentMenuItem.click();
    displayDocument.click();

    document2.setText("new test text 2");

    Logger.log("Macro command:");
    MacroCommand macroCommand = new MacroCommand();
    macroCommand.addCommand(openCommand, copyCommand, pasteCommand, simpleCommand);
    MenuItem copyAndPasteDocument = new MenuItem(macroCommand);
    copyAndPasteDocument.click();
  }
}
