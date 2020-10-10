package com.skurski.designpatterns.observer.complex;

public class ObserverPatternDemo {
	
	public static void main(String[] args) { 
		Bank bank = new Bank();
    	Client john = new Client("John", Gender.MALE);
    	bank.addClient(john);
	}

}
