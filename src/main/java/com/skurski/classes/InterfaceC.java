package com.skurski.classes;

public interface InterfaceC extends InterfaceB {

    default void doSomething() {
        System.out.println("interface C");
    }
}
