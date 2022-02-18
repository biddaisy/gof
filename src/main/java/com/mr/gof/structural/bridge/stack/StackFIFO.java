package com.mr.gof.structural.bridge.stack;

public class StackFIFO extends Stack {
  private final StackImpl stackImpl = new StackListImpl();

  public StackFIFO() {
    super(StackImplType.ARRAY);
  }

  public StackFIFO(StackImplType stackImplType) {
    super(stackImplType);
  }

  @Override
  public int pop() {
    while (!isEmpty()) {
      stackImpl.push(super.pop());
    }
    int ret = stackImpl.pop();
    while (!stackImpl.isEmpty()) {
      push(stackImpl.pop());
    }
    return ret;
  }
}
