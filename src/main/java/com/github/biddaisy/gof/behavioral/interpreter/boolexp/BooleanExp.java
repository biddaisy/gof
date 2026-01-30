package com.github.biddaisy.gof.behavioral.interpreter.boolexp;

public interface BooleanExp {

    boolean evaluate(Context context);
    BooleanExp replace(String expName, BooleanExp booleanExp);
    BooleanExp copy();

    String string();
}
