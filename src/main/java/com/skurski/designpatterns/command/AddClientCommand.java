package com.skurski.designpatterns.command;

public class AddClientCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute Add Client Command");
	}

	@Override
	public void printCommandInfo() {
		System.out.println("Add Client Command");	
	}

}
