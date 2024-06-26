/**
 * 
 */
package com.flipkart.business;


public class FlipfitAdminBusiness implements FlipfitAdminInterface {
	public boolean approveGymOwnerRequest(int GymOwnerID) {
		System.out.println("Approved Request");
		return true;
	};
	public void viewPendingGymOwnerRequests() {
		System.out.println("View Pending Request");
	};

	public void FlipfitGyms()
	{
		System.out.println("View FlipfitGyms");
	}

	public void viewFlipfitCustomers()
	{
		System.out.println("View FlipfitCustomers");
	}

}
