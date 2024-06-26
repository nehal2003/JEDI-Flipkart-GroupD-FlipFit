/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.*;
/**
 * 
 */
public class AdminClient {
	public void adminMenu()
	{
		FlipfitAdminInterface service= new FlipfitAdminBusiness();
		service.approveGymOwnerRequest(101);
		service.viewPendingGymOwnerRequests();
		service.viewFlipfitCustomers();
		
	System.out.println("Press 1 for approving gym owner request"); 
	System.out.println("Press 2 for viewing pending gym owner requests");
	System.out.println("Press 3 for approving gym registration requests");
	System.out.println("Press 4 for viewing pending gym registration requests");
	System.out.println("Press 5 to exit");
	}

}
