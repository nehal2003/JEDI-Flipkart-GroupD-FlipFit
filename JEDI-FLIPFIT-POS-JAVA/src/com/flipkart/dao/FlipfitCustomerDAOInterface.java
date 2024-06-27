package com.flipkart.dao;

import com.flipkart.bean.FlipfitCustomer;

public interface FlipfitCustomerDAOInterface {
	
	public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    public boolean isUserValid(String userName, String password);
    public FlipfitCustomer getCustomerById(String userName);
    
}
