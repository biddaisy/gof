package com.mr.gof.visitor;

/**
 * Created by Ramanovich on 1/4/2017.
 */
public interface Acceptor {

    void accept(Visitor visitor);
}
