package com.skurski.designpatterns_practise.adapter;

public class MotorcycleExternalTool {

    public String fire() {
        System.out.println("fire");
        return "fire";
    }

    public String stoppie() {
        System.out.println("stoppie");
        return "stoppie";
    }

    public String open() {
        System.out.println("open");
        return "open";
    }
}
