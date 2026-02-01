package com.github.biddaisy.gof.creational.singleton.statickblock;

public class Demo {
    public static void main(String[] args) {
        StaticBlockSingleton s = StaticBlockSingleton.getInstance();
        s.doWork();
    }
}
