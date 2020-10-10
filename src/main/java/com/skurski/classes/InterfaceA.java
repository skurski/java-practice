package com.skurski.classes;

public interface InterfaceA {

    default void doSomething() {
        System.out.println("interfaceA");
    }
}
