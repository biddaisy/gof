package com.github.biddaisy.gof.creational.singleton.registry;

public class SingletonRegistryDemo {

    static void main(String[] args) {

        // Retrieve eager Foo singleton
        FooSingleton foo = SingletonRegistry.get("Foo");
        foo.doWork();
        // Retrieve eager Bar singleton
        BarSingleton bar = SingletonRegistry.get("Bar");
        bar.doWork();
        // Retrieve lazy LazyFoo singleton
        LazyFooSingleton lazyFoo = SingletonRegistry.get("LazyFoo");
        lazyFoo.doWork();
    }
}
