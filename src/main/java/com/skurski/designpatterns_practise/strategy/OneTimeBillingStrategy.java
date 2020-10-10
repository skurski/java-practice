package com.skurski.designpatterns_practise.strategy;

public class OneTimeBillingStrategy implements BillingStrategy {

    @Override
    public void execute() {
        System.out.println("This is only one time payment");
    }
}
