package com.skurski.designpatterns.abstractfactory;

public class SavingAccount extends AbstractAccount {
	public SavingAccount(double balance) {
        super(balance);
    }
	
	@Override
    public void verifyAccount(){
		System.out.format("Saving account, balance = %.2f%n", balance);
    }

}