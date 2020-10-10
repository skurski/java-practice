package com.skurski.designpatterns.chainofresponsibility;

public class FinancialSpecialist extends AbstractSpecialist {
	
	@Override
	protected boolean makeDecision(double creditRate, double clientSalary, boolean propertyGuarantee) {
		boolean decision = false;
		if (creditRate <= clientSalary/3) {
			decision = true;
		}
		
		if (null != this.nextSpecialist && decision) {
			System.out.format("Approved at the %s level, passing to next specialist%n", this.getClass().getSimpleName());
			return this.nextSpecialist.makeDecision(creditRate, clientSalary, propertyGuarantee);
		}
		
        printFinalDecision(decision);
		
		return decision;
	}

}
