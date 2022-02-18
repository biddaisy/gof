package com.mr.gof.structural.bridge.stack;

public interface StackImpl {
  void push(int i);

  int pop();

  int top();

  boolean isEmpty();

  boolean isFull();
}
