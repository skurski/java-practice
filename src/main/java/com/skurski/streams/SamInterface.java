package com.skurski.streams;

public class SamInterface {

    @FunctionalInterface
    public interface Greeting {
        String hello(String name);
    }

    public void doHello(String name, Greeting greeting) {
        String text = greeting.hello(name);

        System.out.println("Result: " + text);
    }

    public static void main(String[] args) {

        new SamInterface().doHello("Peter", name -> "Hello " + name + "!");
    }
}
