/**
 * 
 */
package com.flipkart.business;
import  com.flipkart.bean.*;

public class FlipfitGymOwnerBusiness {
	
	public boolean registerGym() {
		return true;
	};

	
	public boolean viewMyGyms(int gymOwnerID) {
		return true;
	}

	
	public Integer fetchGymID(Integer gymOwnerID, String gymName, String gymAddress) {return 0;};

	
	public void addSlots(SlotDetails slot) {};

	public Integer getGymOwnerID(String email) {
		return 1;
	};
	
	public void viewProfile(Integer gymOwnerID) {};
}
