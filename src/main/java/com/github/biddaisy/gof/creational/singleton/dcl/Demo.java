package com.github.biddaisy.gof.creational.singleton.dcl;

public class Demo {
    public static void main(String[] args) {
        DoubleCheckedLockingSingleton s = DoubleCheckedLockingSingleton.getInstance();
        s.doWork();
    }
}

