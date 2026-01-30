package com.github.biddaisy.gof.behavioral.command;

public class SimpleCommand implements Command{

    private final Actionable actionable;

    public SimpleCommand(Actionable actionable) {
        this.actionable = actionable;
    }

    @Override
    public void execute() {
        actionable.action();
    }
}
