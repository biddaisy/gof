package com.mr.gof.visitor;

import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public abstract class Node {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept (Visitor visitor);/*{
        visitor.visit(this);
    }*/
}
