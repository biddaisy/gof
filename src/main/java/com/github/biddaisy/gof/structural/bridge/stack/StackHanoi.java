package com.github.biddaisy.gof.structural.bridge.stack;

public class StackHanoi extends Stack {
  private int totalRejected = 0;

  public StackHanoi() {
    super(StackImplType.ARRAY);
  }

  public StackHanoi(StackImplType stackImplType) {
    super(stackImplType);
  }

  public int reportRejected() {
    return totalRejected;
  }

  @Override
  public void push(int in) {
    if (!isEmpty() && in > top()) {
      totalRejected++;
    }
    else {
      super.push(in);
    }
  }
}
