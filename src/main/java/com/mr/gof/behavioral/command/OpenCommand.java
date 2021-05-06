package com.mr.gof.behavioral.command;

public class OpenCommand implements Command{

  private final Application application;

    private final Document document;

    public OpenCommand(Application application, Document document) {
        this.application = application;
        this.document = document;
    }

    @Override
    public void execute() {
        application.addDocument(document);
        application.openDocument();
    }
}
