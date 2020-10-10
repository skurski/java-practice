package com.skurski.designpatterns_practise.strategy;

public class ContractFactory {

    public static Contract of(ContractType type) {
        switch (type) {
            case SUBSCRIPTION: return new Contract(new SubscriptionBillingStrategy(), ContractType.SUBSCRIPTION);
            case RECURRING: return new Contract(new RecurringBillingStrategy(), ContractType.RECURRING);
            default: return new Contract(new OneTimeBillingStrategy(), ContractType.ONE_TIME);
        }
    }
}
