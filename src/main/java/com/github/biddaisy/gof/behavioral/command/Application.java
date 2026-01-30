package com.mr.gof.behavioral.command;

public class Application {

  private Document document;

  private final StringBuilder buffer = new StringBuilder();

  public void addToBuffer(String text) {
    buffer.append(text);
  }

  public void addDocument(Document document) {
    this.document = document;
  }

  public Document getDocument() {
    return document;
  }

  public void openDocument() {
    System.out.printf("Document name '%s':", document.getName());
    System.out.printf("Document text '%s'\n", document.getText());
  }

  public void paste() {
    document.setText(buffer.toString());
  }

  public void copy(Document document) {
    buffer.setLength(0);
    buffer.append(document.getText());
  }
}
