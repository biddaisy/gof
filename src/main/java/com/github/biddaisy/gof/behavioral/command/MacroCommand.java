package com.github.biddaisy.gof.behavioral.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacroCommand implements Command{

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command... commands){
        this.commands.addAll(Arrays.asList(commands));
    }

    public void removeCommand(Command... commands){
        this.commands.removeAll(Arrays.asList(commands));
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}
