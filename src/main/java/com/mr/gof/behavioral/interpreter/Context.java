package com.mr.gof.behavioral.interpreter;

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
}
