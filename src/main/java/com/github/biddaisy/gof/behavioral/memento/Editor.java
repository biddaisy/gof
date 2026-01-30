package com.mr.gof.behavioral.memento;

import com.github.biddaisy.gof.Logger;

import java.util.ArrayList;
import java.util.List;

public class Editor {

  private final Document document = new Document();

  private final List<Object> documentHistory = new ArrayList<>();

  private int documentIndex;

  public void updateContent(String content) {
    document.setContent(content);
    documentHistory.add(document.save());
    documentIndex = documentHistory.size() - 1;
  }

  public boolean undo() {
    if (documentIndex == 0)
      return false;
    document.restore(documentHistory.get(--documentIndex));
    return true;
  }

  public boolean redo() {
    if (documentIndex == documentHistory.size() - 1)
      return false;
    document.restore(documentHistory.get(++documentIndex));
    return true;
  }

  public void displayContent() {
    Logger.log(document.getContent());
  }

}
