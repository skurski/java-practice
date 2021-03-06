package com.skurski.designpatterns.javabeans;

import java.util.Date;

public class Customer {
	private Gender gender;
	private String surname;
	private String firstName;
	@SuppressWarnings("unused")
	private String middleName;
	@SuppressWarnings("unused")
	private Date birthday;
	@SuppressWarnings("unused")
	private Date becomeCustomer;
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setBecomeClient(Date becomeCustomer) {
		this.becomeCustomer = becomeCustomer;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(gender.getSalute())
		  .append(" ")
		  .append(surname)
		  .append(", ")
		  .append(firstName);
		return sb.toString();
	}
	
	public static void main (String[] args) {
		Customer firstClient = new Customer();
		firstClient.setGender(Gender.MALE);
		firstClient.setSurname("Smith");
		firstClient.setFirstName("John");
		System.out.println(firstClient);
	}

}
