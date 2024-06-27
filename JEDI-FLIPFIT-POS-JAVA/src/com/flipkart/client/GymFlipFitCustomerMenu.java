/**
 * 
 */
import com.flipkart.business.*;
import com.flipkart.client.*;

//package com.flipkart.business;
import java.util.Scanner;
import com.flipkart.bean.User;
import com.flipkart.business.FlipfitCustomerBusiness;
import com.flipkart.business.FlipfitCustomerInterface;


/**
 * 
 */
//public class GymFlipFitCustomerMenu {
//
//}
//



//import java.util.Scanner;
//import com.flipkart.bean.User;
//import com.flipkart.business.FlipFitCustomerBusiness;
//import com.flipkart.business.FlipFitCustomerInterface;

public class GymFlipFitCustomerMenu {
	public static void customerMenu(Scanner in) {

		FlipfitCustomerInterface customer = new FlipfitCustomerBusiness();
		System.out.println("Do you know your UserID? Enter Y for yes and N for no");
		String userChoice = in.next();
		Integer UserID = null;
		User userLogin = new User();
		switch (userChoice){
			case "Y":
				UserID = in.nextInt();
				break;
			case "N":
				System.out.println("Enter your email:");
				String email = in.next();
				userLogin.setEmailID(email);
				System.out.println("Enter your password:");
				String password = in.next();
				userLogin.setPassword(password);
				userLogin.setRole("Customer");
				break;
			default:
				System.out.println("Enter a valid choice!");

		}

		
		while(true) {
			System.out.println("----Customer Menu----");
			System.out.println("Press 1 to view gyms");
			System.out.println("Press 2 to book slot");
			System.out.println("Press 3 to cancel booked slots");
			System.out.println("Press 4 to view all bookings");
//			System.out.println("Press 5 to view gym info");
//			System.out.println("Press 6 to check available slots");
//			System.out.println("Press 7 to check profile");
			System.out.println("Press 5 to exit");
			
			int option = in.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter your city:");
					String mycity = in.next();
					customer.viewGymCentreDetailsByCity(mycity);
//						System.out.println("No gyms currently available");
					break;
				case 2:
					System.out.println("Enter gym ID");
					Integer gymID = in.nextInt();
					System.out.println("Enter slot number");
					Integer slotnumber = in.nextInt();
					customer.bookSlot(gymID, slotnumber, UserID);
					break;
				case 3:
					System.out.println("Enter gym ID");
					gymID = in.nextInt();
					System.out.println("Enter slot number");
					slotnumber = in.nextInt();
					customer.cancelBookedSlots(gymID, slotnumber, UserID);
					break;
				case 4:
					customer.viewAllBookings(UserID);
					break;
//				case 5:
//					System.out.println("Enter Gym ID: ");
//					gymID = in.nextInt();
//					customer.getGymInfo(gymID);
//					break;
////				case 6:
//					//customer.checkBookingList();
//					break;
//				case 6:
//					System.out.println("Enter Gym ID: ");
//					gymID = in.nextInt();
//					if(!customer.checkAvailableSlots(gymID)) {
//						System.out.println("No slots available");
//					}
//					break;
//				case 7:
//					customer.viewProfile(UserID);
//					break;
				case 5:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}

}