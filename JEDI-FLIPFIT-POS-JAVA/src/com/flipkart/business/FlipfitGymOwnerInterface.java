/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.SlotDetails;

/**
 * 
 */
public interface FlipfitGymOwnerInterface {
	
	public boolean registerGymOwner();
	
	public void addSlots(SlotDetails slot);

	public void viewGymcentres();
	
	public void viewProfile(Integer gymOwnerID);

}
