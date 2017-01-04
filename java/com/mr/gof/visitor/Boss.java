package com.mr.gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public class Boss extends Employee implements ParentNode {

    private int annualBonus;
    private ParentNode parentNodeDelegate = new ParentNodeImpl();

    public int getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(int annualBonus) {
        this.annualBonus = annualBonus;
    }

    public List<Acceptor> getChildAcceptors(){
        List<Acceptor> acceptors = new ArrayList<Acceptor>();

        List<Node> nodes = getChildren();
        for (Node node : nodes){
            if ( node instanceof Acceptor ){
                acceptors.add((Acceptor) node);
            }
        }
        return acceptors;
    }

    @Override
    public void accept (Visitor visitor){
        visitor.visit(this);
        acceptChildren(visitor);
    }

    public void acceptChildren(Visitor visitor){
        List<Acceptor> childAcceptors = getChildAcceptors();
        for (Acceptor acceptor : childAcceptors){
            acceptor.accept(visitor);
        }
    }

    @Override
    public List<Node> getChildren() {
        return parentNodeDelegate.getChildren();
    }

    @Override
    public void addChild(Node childNode) {
        parentNodeDelegate.addChild(childNode);
    }
}
