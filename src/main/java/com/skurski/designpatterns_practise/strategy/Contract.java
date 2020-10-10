package com.skurski.designpatterns_practise.strategy;

public class Contract {

    private BillingStrategy billingStrategy;

    private ContractType contractType;

    public Contract(BillingStrategy billingStrategy, ContractType contractType) {
        this.billingStrategy = billingStrategy;
        this.contractType = contractType;
    }

    public void processPayment() {
        billingStrategy.execute();
    }

    public BillingStrategy getBillingStrategy() {
        return billingStrategy;
    }

    public ContractType getContractType() {
        return contractType;
    }
}
