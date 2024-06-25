/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.CustomerBusiness;

/**
 * 
 */
public class CustomerClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerBusiness service= new CustomerBusiness();
		service.createCustomer();
		System.out.println("update customer-->"+ service.updateCustomer(101));
		System.out.println("delete customer-->"+ service.deleteCustomer(101));
		
	}

}
