package com.github.biddaisy.gof.creational.singleton.holder;

public class Demo {
    public static void main(String[] args) {
        HolderSingleton s = HolderSingleton.getInstance();
        s.doWork();
    }
}
