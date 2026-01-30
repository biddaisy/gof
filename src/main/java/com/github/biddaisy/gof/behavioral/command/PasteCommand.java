package com.github.biddaisy.gof.behavioral.command;

public class PasteCommand implements Command {

  private final Application application;

  public PasteCommand(Application application) {
    this.application = application;
  }

  @Override
  public void execute() {
    application.paste();
  }
}
