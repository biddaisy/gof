package com.github.biddaisy.gof.behavioral.command;

public class CopyCommand implements Command {

  private final Application application;

  private final Document document;

  public CopyCommand(Application application, Document document) {
    this.application = application;
    this.document = document;
  }

  @Override
  public void execute() {
    application.copy(document);
  }
}
