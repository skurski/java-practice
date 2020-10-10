package com.skurski.designpatterns.bridge;

public interface ForeignAccount {
	
	public void verifyAccount();
	public double getBalance();
	public String getCurrencyName();

}
