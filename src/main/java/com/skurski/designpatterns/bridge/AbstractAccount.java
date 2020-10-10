package com.skurski.designpatterns.bridge;

public abstract class AbstractAccount {
	
	ForeignAccount foreignAccount; 
        
    abstract void verifyAccount();

    public AbstractAccount(ForeignAccount foreignAccount){
    	this.foreignAccount = foreignAccount;
    }
    
    public void setForeignAccount(ForeignAccount foreignAccount) {
    	this.foreignAccount = foreignAccount;
    }
    
}