package com.mr.gof.behavioral.iterator;

public interface Iterator {
  Object first();
  Object next();
  boolean isDone();
  Object currentObject();
}
