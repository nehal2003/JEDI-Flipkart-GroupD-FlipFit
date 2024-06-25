/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class CustomerBusiness {
	
	//add // update // delete // list
	
	public void createCustomer() {
		System.out.println("Customer Created-->");
		
	}
	public boolean updateCustomer(int customerId) {
		System.out.println("Customer is updated by id-->" + customerId);
		return true;
	}
	public boolean deleteCustomer(int customerId) {
		System.out.println("Customer is deleted by id-->" + customerId);
		return true;
	}
	public void listCustomer() {
		System.out.println("customer display over here-->");
	}

}
