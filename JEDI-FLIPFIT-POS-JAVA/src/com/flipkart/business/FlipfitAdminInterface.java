/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface FlipfitAdminInterface {
	
	public boolean approveGymOwnerRequest(int GymOwnerID);
    public void viewPendingGymOwnerRequests();
    public void FlipfitGyms();
    public void viewFlipfitCustomers();
}
