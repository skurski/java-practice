package com.skurski.designpatterns.observer.complex;

public class EmailException extends Exception {
	private static final long serialVersionUID = -1638708431741498605L;

	public EmailException(String message){
        super(message);
    }
}