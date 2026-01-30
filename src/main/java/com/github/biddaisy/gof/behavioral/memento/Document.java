package com.mr.gof.behavioral.memento;

public class Document {

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Memento save() {
    return new Memento(content);
  }

  public void restore(Object object) {
    this.content = ((Memento) object).content;
  }

  private static class Memento {
    private final String content;

    public Memento(String content) {
      this.content = content;
    }
  }
}
