package com.github.biddaisy.gof.creational.singleton.synchronizedmethod;

public class Demo {
    public static void main(String[] args) {
        SynchronizedSingleton s = SynchronizedSingleton.getInstance();
        s.doWork();
    }
}
