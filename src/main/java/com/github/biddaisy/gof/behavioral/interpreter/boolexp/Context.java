package com.github.biddaisy.gof.behavioral.interpreter.boolexp;

import java.util.HashMap;
import java.util.Map;

public class Context {

  private final Map<VariableExp, Boolean> values = new HashMap<>();

  public boolean lookup(String name) {
    return values.entrySet().stream().filter(e -> e.getKey().getName().equals(name)).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("name " + name + " not found")).getValue();
  }

  public void assign(VariableExp variableExp, boolean value) {
    values.put(variableExp, value);
  }

  public String string() {
    return values.entrySet().stream()
        .reduce(new StringBuilder(), (sb, e2) -> sb.append(" ").append(e2.getKey().string()).append("=").append(e2.getValue()), (sb1, sb2) -> sb1).toString();
  }
}
