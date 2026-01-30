package com.github.biddaisy.gof.behavioral.interpreter.boolexp;

import com.github.biddaisy.gof.Logger;

public class Test {

    public static void main(String... args){
        //(true and x) or (y and (not x))

        BooleanExp expression;
        Context context = new Context();

        VariableExp x = new VariableExp("X");
        VariableExp y = new VariableExp("Y");

        expression = new OrExp(
                new AndExp(new Constant(true), x),
                new AndExp(y, new NotExp(x))
        );

        context.assign(x, false);
        context.assign(y, true);

        boolean result = expression.evaluate(context);

        Logger.log("values: " + context.string());
        Logger.log("on expression: " + expression.string());
        Logger.log("result: " + result);

        // x and y
        expression = new AndExp(x, y);
        result = expression.evaluate(context);
        Logger.log("on expression: " + expression.string());
        Logger.log("result: " + result);

        // x or y
        expression = new OrExp(x, y);
        result = expression.evaluate(context);
        Logger.log("on expression: " + expression.string());
        Logger.log("result: " + result);

        // not x
        expression = new NotExp(x);
        result = expression.evaluate(context);
        Logger.log("on expression: " + expression.string());
        Logger.log("result: " + result);
    }

}
