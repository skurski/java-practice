package com.skurski.designpatterns.command;

public class WithdrawCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute Withdraw Command");
	}

	@Override
	public void printCommandInfo() {
		System.out.println("Withdraw Command");	
	}

}
