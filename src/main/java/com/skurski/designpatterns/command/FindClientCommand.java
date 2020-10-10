package com.skurski.designpatterns.command;

public class FindClientCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute Find Client Command");
	}

	@Override
	public void printCommandInfo() {
		System.out.println("Find Client Command");
	}

}
