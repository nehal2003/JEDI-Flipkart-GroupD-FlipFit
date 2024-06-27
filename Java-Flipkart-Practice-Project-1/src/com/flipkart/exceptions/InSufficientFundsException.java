package com.flipkart.exceptions;

/**
 * @author Dell
 *
 */
public class InSufficientFundsException  extends Exception{
	
	// Use some constructor & custom method for Exception 
	
	
 private double amount;
 
 public InSufficientFundsException(double amount) {
	 
	 this.amount=amount;
 }
	
 
 // custome method which is return the less amount How much less for Withdrawal
 
 public double getAmount() {
	 
	 return amount;
 }

}
