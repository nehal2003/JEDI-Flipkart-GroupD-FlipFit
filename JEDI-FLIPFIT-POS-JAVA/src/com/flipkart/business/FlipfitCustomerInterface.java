/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.FlipfitBookingList;
import com.flipkart.bean.FlipfitCustomer;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.List;

/**
 * 
 */
public interface FlipfitCustomerInterface {
	
	List<FlipfitGymInformation> getAllGymCenterDetailsByCity(String city);
    List<SlotDetails> getAvailableSlots(String centreID, Date date);
    List<FlipfitBookingList> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBookingbyID(String bookingID);
//    FlipfitCustomer registerCustomer(FlipfitCustomer customer);
    FlipfitCustomer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);



}
