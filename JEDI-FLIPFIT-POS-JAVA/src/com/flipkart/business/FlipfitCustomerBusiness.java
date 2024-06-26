
package com.flipkart.business;

import com.flipkart.bean.User;

public class FlipfitCustomerBusiness {
	public void registerCustomer(User Customer) {};
	
	public void updatePassword(User Customer, String password) {};
	
	public void viewGyms() {}


	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) {return true;}



	
	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) {return true ;}



	
	public void viewAllBookings(Integer userID) {}


	

}
