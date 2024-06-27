package com.flipkart.client;
import com.flipkart.bean.*;
import java.util.Scanner;

public class GymFlipFitApplication {
	public static void main(String[] args) {
		// TODO Auto-generated
        System.out.println("Welcome to FlipFit Application for Slot Booking!");
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.println("----Menu----");
        	System.out.println("Press 1 for Login");
        	System.out.println("Press 2 for Registration of User");
        	System.out.println("Press 3 for Updating Password");
        	System.out.println("Press 4 to Exit");
        	
        	int option = in.nextInt();
        	boolean flag = false;
        	
        	switch (option) {
        		case 1:
        			User userLogin = new User();
        			System.out.println("Enter emailID");
        			userLogin.setEmailID(in.next());
        			System.out.println("Enter password");
        			userLogin.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner)");
        			userLogin.setRole(in.next());
        			break;
        		case 2:
        			User user  = new User();
        			System.out.println("Enter email ID");
					String emailID = in.next();
        			//user.setEmailID(in.next());
        			System.out.println("Create a password");
					String password = in.next();
        			//user.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner)");
					String role = in.next();
        			user.setRole(role);
					switch (role){
						case "GymOwner":
							FlipfitGymOwner gymOwner = new FlipfitGymOwner();
							gymOwner.setEmailID(emailID);
							gymOwner.setPassword(password);
							System.out.println("Enter your name");
							gymOwner.setName(in.next());
							System.out.println("Enter your Address");
							gymOwner.setAddress(in.next());
							System.out.println("Enter your IDProof(Aadhar number)");
							gymOwner.setIDProof(in.next());
							break;
						case "Customer":
							user.setEmailID(emailID);
							user.setPassword(password);
							System.out.println("Customer registered!");
							break;
						default:
							System.out.println("Please enter a valid role!");


					}

        			break;
        		case 3:
        			user = new User();
        			System.out.println("Enter emailID");
        			user.setEmailID(in.next());
        			System.out.println("Enter new password");
        			user.setPassword(in.next());
        			System.out.println("New password updated");
        			break;
        		case 4:
        			System.out.println("Exit");
        			flag = true;
        			break;
        		default:
        			System.out.println("Please enter a valid option.");
        			break;
        	}
        	if(flag) {
        		break;
        	}
        }
		
	}
}