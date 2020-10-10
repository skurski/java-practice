package com.skurski.designpatterns.observer.simple;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    @FunctionalInterface
    public interface Subscriber {
        void update(String event);
    }

    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscribers(String event) {
        subscribers.forEach((sub) -> sub.update(event));
    }

    public static void main(String[] args) {

        Publisher publisher = new Publisher();

        publisher.addSubscriber((event) -> {
            System.out.println("First sub received data: " + event);
        });
        publisher.addSubscriber((event) -> {
            System.out.println("Second sub received data: " + event);
        });
        
        publisher.notifySubscribers("Salary increased");
    }
}
