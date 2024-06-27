package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.*;

public interface BookingGymDAOInterface {
	
	public void addBooking(String userName, String scheduleID);

    public List<FlipfitBookingList> getBookingByCustomerId(String customerId);

    public void cancelBookingById(String bookingID);
	
}
