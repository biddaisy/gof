package com.mr.gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public abstract class ParentNode extends Node {

    private List<Node> children;

    public List<Node> getChildren(){
        return children;
    }

    public void addChild(Node childNode){
        if ( children == null ){
            children = new ArrayList<Node>();
        }
        children.add(childNode);
    }

/*
    @Override
    public void accept (Visitor visitor){
        visitor.visit(this);
        List<Node> children = getChildren();
        for (Node child : children){
            visitor.visit(child);
        }
    }
*/
}
