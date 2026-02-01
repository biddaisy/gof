package com.github.biddaisy.gof.creational.singleton.eager;

public class Demo {
    public static void main(String[] args) {
        EagerSingleton s = EagerSingleton.getInstance();
        s.doWork();
    }
}

