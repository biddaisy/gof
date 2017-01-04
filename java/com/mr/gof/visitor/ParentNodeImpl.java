package com.mr.gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 1/4/2017.
 */
public class ParentNodeImpl implements ParentNode {

    private List<Node> children = new ArrayList<Node>();

    @Override
    public List<Node> getChildren(){
        return children;
    }

    @Override
    public void addChild(Node childNode){
        children.add(childNode);
    }

}
