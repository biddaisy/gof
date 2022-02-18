package com.mr.gof.structural.bridge.stack;

public class Stack {
  private final StackImpl impl;

  public Stack(StackImplType stackImplType) {
    if (stackImplType == StackImplType.ARRAY) {
      impl = new StackArrayImpl();
    }
    else
      if (stackImplType == StackImplType.LIST) {
        impl = new StackListImpl();
      }
      else {
        throw new IllegalArgumentException("Stack: unknown parameter '" + stackImplType + "'");
      }
  }

  public Stack() {
    this(StackImplType.ARRAY);
  }

  public void push(int in) {
    impl.push(in);
  }

  public int pop() {
    return impl.pop();
  }

  public int top() {
    return impl.top();
  }

  public boolean isEmpty() {
    return impl.isEmpty();
  }

  public boolean isFull() {
    return impl.isFull();
  }
}
