package com.github.biddaisy.gof.behavioral.command;

public class MenuItem {

    private final Command command;

    public MenuItem(Command command) {
        this.command = command;
    }

    public void click(){
        command.execute();
    }
}
