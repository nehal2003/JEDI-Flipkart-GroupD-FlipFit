/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipfitBookingList;
import com.flipkart.bean.ScheduleBooking;
import com.flipkart.bean.SlotDetails;
//import com.flipkart.exceptions.BookingFailedException;
//import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;


public class FlipfitBookingBusiness implements FlipfitBookingInterface {
	
	private final BookingGymDAOImpl bookingDAO = new BookingGymDAOImpl();
    private final ScheduleBusiness scheduleService  = new ScheduleBusiness();

    private final SlotBusiness slotService = new SlotBusiness();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        //return whether the customer has already booked a slot at same timing
        SlotDetails slot = slotService.getSlotByID(slotId);
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }
    public void addBooking(String userName, String scheduleID) {
            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
            if(!isAvailable){
                System.out.println("No seats available for the booking");
                return;
            }
            bookingDAO.addBooking(userName, scheduleID);

    }

    public List<FlipfitBookingList> getBookingByCustomerId(String customerId){
       
            return bookingDAO.getBookingByCustomerId(customerId);
        

    }


    public void cancelBooking(String bookingID) {   
            FlipfitBookingList booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleID(),1);

    }
	

}
