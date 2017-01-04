package com.mr.gof.visitor;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class NodeTree {

    private ParentNode rootNode;

    public void setRootNode(ParentNode rootNode) {
        this.rootNode = rootNode;
    }

    public ParentNode getRootNode() {
        return rootNode;
    }

    public void traverse (Visitor visitor ){
        if ( rootNode instanceof Acceptor ) {
            ((Acceptor)rootNode).accept(visitor);
        }
    }
}
