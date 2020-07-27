package com.mr.gof.behavioral.memento;

public class Test {

  public static void main(String[] args) {
    Editor editor = new Editor();
    editor.updateContent("step 1");
    editor.displayContent();
    editor.updateContent("step 2");
    editor.displayContent();
    editor.updateContent("step 3");
    editor.displayContent();
    editor.updateContent("step 4");
    editor.displayContent();
    if (editor.undo()) {
      editor.displayContent();
    }
    if (editor.redo()) {
      editor.displayContent();
    }
  }

}
