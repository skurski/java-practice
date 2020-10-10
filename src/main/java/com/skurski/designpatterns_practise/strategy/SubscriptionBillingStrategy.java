package com.skurski.designpatterns_practise.strategy;

public class SubscriptionBillingStrategy implements BillingStrategy {
    @Override
    public void execute() {
        System.out.println("Payment up front for 12 months - billing strategy");
    }
}
