package com.mr.gof.structural.bridge.stack;

public class StackArrayImpl implements StackImpl {
  private final int[] items;

  private int total = -1;

  public StackArrayImpl() {
    this.items = new int[12];
  }

  public StackArrayImpl(int cells) {
    this.items = new int[cells];
  }

  @Override
  public void push(int i) {
    if (!isFull()) {
      items[++total] = i;
    }
  }

  @Override
  public boolean isEmpty() {
    return total == -1;
  }

  @Override
  public boolean isFull() {
    return total == items.length - 1;
  }

  @Override
  public int top() {
    if (isEmpty()) {
      return -1;
    }
    return items[total];
  }

  @Override
  public int pop() {
    if (isEmpty()) {
      return -1;
    }
    return items[total--];
  }
}
