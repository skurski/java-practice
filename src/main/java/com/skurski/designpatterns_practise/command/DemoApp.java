package com.skurski.designpatterns_practise.command;

public class DemoApp {

    public static void main(String[] args) {
        Operation operation = new Operation();

        Menu menu = new Menu();
        menu.register("in", operation::checkIn);
        menu.register("out", operation::checkOut);
        menu.register("spa", operation::spa);

        menu.show();
    }
}
