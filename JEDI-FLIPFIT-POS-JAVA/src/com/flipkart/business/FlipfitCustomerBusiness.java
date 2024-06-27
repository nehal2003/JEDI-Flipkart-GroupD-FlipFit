
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipfitBookingList;
import com.flipkart.bean.FlipfitCustomer;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.List;


public class FlipfitCustomerBusiness implements FlipfitCustomerInterface{
	private FlipfitCustomerDAOImpl customerDAO = new FlipfitCustomerDAOImpl();
    private FlipfitGymCentreInterface gymCentreService = new FlipfitGymCentreBusiness();
    private FlipfitBookingInterface bookingService = new FlipfitBookingBusiness();
    private ScheduleInterface scheduleService = new ScheduleBusiness();

    private SlotInterface slotService = new SlotBusiness();

    public List<FlipfitGymInformation> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    public List<SlotDetails> getAvailableSlots(String centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    public List<FlipfitBookingList> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }


    public boolean bookSlot(String userName,Date date, String slotId,String centreId){
        if(!slotService.isSlotValid(slotId,centreId)){
            System.out.println("INVALID_SLOT");
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        //create booking
        boolean isOverlap = bookingService.checkBookingOverlap(userName,date,slotId);
        if(isOverlap) {
            System.out.println("There exists a conflicting booking, First cancel it!!!!");
            return false;
        }
        bookingService.addBooking(userName, scheduleId);
        return true;
    }



    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    public FlipfitCustomer registerCustomer(FlipfitCustomer customer) {
        
            return customerDAO.registerCustomer(customer);
    }

    public FlipfitCustomer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        
            return customerDAO.isUserValid(userName,password);
    }


	

}
