/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.*;
import com.flipkart.exceptions.*;
/**
 * 
 */
public class BankClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
				// craete the instance of service class here 
				
				BankingService service=new BankingService(101);
				System.out.println("Depositing the $500 here-->");
				service.deposit(500.00);
				
				try {
					
					System.out.println("\nWithdrawl the $100 here --->");
					
					service.withdraw(100.00);
					
					System.out.println("\n Withdrawl the $600 here --->");
					service.withdraw(600.00);
					
				}catch (InSufficientFundsException ex) {
					// TODO: handle exception
					
					System.out.println("sorry , but you are short $-->" +ex.getAmount());
				}
	}

}
