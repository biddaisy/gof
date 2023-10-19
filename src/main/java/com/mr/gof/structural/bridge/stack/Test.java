package com.mr.gof.structural.bridge.stack;

import java.util.Random;

import static com.mr.gof.Logger.log;

public class Test {

  public static void main(String[] args) {
    Stack[] stacks = { new Stack(StackImplType.ARRAY), new Stack(StackImplType.LIST), new StackFIFO(), new StackHanoi() };
    for (int i = 1; i < 15; i++) {
      for (int j = 0; j < 3; j++) {
        stacks[j].push(i);
      }
    }
    Random rn = new Random();
    for (int i = 1; i < 15; i++) {
      stacks[3].push(rn.nextInt(20));
    }
    for (Stack stack : stacks) {
      while (!stack.isEmpty()) {
        log(stack.pop() + "  ");
      }
      log("\n");
    }
    log("total rejected is " + ((StackHanoi) stacks[3]).reportRejected());
  }
}
