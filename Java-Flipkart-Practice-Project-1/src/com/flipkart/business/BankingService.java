/**
 * 
 */
package com.flipkart.business;
import com.flipkart.exceptions.*;
/**
 * 
 */
public class BankingService {
	private double balance;
	private int number;
	
	public BankingService(int number) {
		
		this.number=number;
	}
	
	
	// define the deposit method 
	
	public void deposit(double amount) {
		
		balance +=amount;
	}
	
	
	public void withdraw(double amount) throws InSufficientFundsException {
		
		
		if(amount<=balance) {
			
			balance-=amount;
		}else {
			
			double needs=amount-balance;
			
			throw new InSufficientFundsException(needs);
		}
		
}
