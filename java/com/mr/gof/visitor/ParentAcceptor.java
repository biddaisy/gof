package com.mr.gof.visitor;

import java.util.List;

/**
 * Created by Ramanovich on 1/4/2017.
 */
public class ParentAcceptor<T extends Employee> implements Acceptor {

    private List<Acceptor> acceptors;
    private T parent;
    public ParentAcceptor(T parent, List<Acceptor> acceptors) {
        this.parent = parent;
        this.acceptors = acceptors;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(parent);
        for (Acceptor acceptor : acceptors){
            acceptor.accept(visitor);
        }
    }
}
