package com.skurski.designpatterns_practise.strategy;

public class RecurringBillingStrategy implements BillingStrategy {
    @Override
    public void execute() {
        System.out.println("Payment every month - recurring strategy");
    }
}
