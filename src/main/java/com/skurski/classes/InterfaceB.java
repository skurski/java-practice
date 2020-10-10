package com.skurski.classes;

public interface InterfaceB {

    default void doSomething() {
        System.out.println("interface B");
    }
}
