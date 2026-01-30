package com.github.biddaisy.gof.structural.bridge.stack;

public class StackListImpl implements StackImpl {
  private Node last;

  @Override
  public void push(int i) {
    if (last == null) {
      last = new Node(i);
    }
    else {
      last.setNext(new Node(i));
      last.getNext().setPrev(last);
      last = last.getNext();
    }
  }

  @Override
  public boolean isEmpty() {
    return last == null;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public int top() {
    if (isEmpty()) {
      return -1;
    }
    return last.getValue();
  }

  @Override
  public int pop() {
    if (isEmpty()) {
      return -1;
    }
    int ret = last.getValue();
    last = last.getPrev();
    return ret;
  }

}
