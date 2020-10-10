package com.skurski.designpatterns_practise.adapter;

public class CarExternalTool {

    public String start() {
        System.out.println("start");
        return "start";
    }

    public String stop() {
        System.out.println("stop");
        return "stop";
    }

    public String accelerate() {
        System.out.println("accelerate");
        return "accelerate";
    }
}
