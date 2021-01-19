package com.mr.gof.behavioral.interpreter.boolexp;

public interface BooleanExp {

    boolean evaluate(Context context);
    BooleanExp  replace(String expName, BooleanExp booleanExp);
    BooleanExp copy();
}
