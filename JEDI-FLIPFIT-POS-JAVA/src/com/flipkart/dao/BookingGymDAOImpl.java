/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.FlipfitBookingList;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class BookingGymDAOImpl implements BookingGymDAOInterface{

	BookingScheduleDAOImpl scheduleDAO  = new BookingScheduleDAOImpl();

    public void  addBooking(String userName, String scheduleID) {
        try {
            //System.out.println(userName + scheduleID);
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FlipFit.Booking (bookingId, userID, scheduleID) values( ?, ?, ?)");
            String trimmedBookingId = (userName + scheduleID).substring(0, 36);
            stmt.setString(1, trimmedBookingId);
            stmt.setString(2, userName);
            stmt.setString(3, scheduleID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
//            throw new BookingFailedException("Booking failed for current slot. Try again later.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }

    }
    public List<FlipfitBookingList> getBookingByCustomerId(String customerId)  {
        List<FlipfitBookingList> allBookingList = new ArrayList<>();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("Select * From FlipFit.Booking where userID = ?");
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
            	FlipfitBookingList booking = new FlipfitBookingList(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

                allBookingList.add(booking);
            }
        } catch(SQLException sql) {
//            throw new BookingFailedException("Could not retrieve Bookings by customer id:  " + customerId);
        } catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return allBookingList;
    }

    public List<UserPlan> getCustomerPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        List<FlipfitBookingList> allBookingList = getBookingByCustomerId(customerId);
        for (FlipfitBookingList booking : allBookingList) {
            try {
                Connection conn = DBConnection.connect();
                PreparedStatement stmt = conn.prepareStatement("select * from slot join schedule where slot.slotId=schedule.slotId and schedule.scheduleId=?");
                stmt.setString(1, booking.getScheduleID());
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    UserPlan userPlan = new UserPlan(
                            rs.getString("slotId"),
                            rs.getString("centreId"),
                            rs.getTime("time").toLocalTime(),
                            rs.getString("scheduleID"),
                            rs.getDate("date")
                    );

                    allUserPlan.add(userPlan);
                }
            } catch (Exception e) {
                System.out.println("Could not retreive User Plan. Try again later.");
            }
        }
        return allUserPlan;
    }

    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime){
        LocalTime endTime = localTime.plusHours(1);

        List<UserPlan> allUserPlan = getCustomerPlan(customerId);
        for(UserPlan userPlan:allUserPlan){

            if(userPlan.getDate().equals(date)){
                if(localTime.compareTo(userPlan.getTime())<=0  && endTime.compareTo(userPlan.getTime())>=0){
                    return true;
                }
                else if(userPlan.getTime().compareTo(localTime)<=0  && userPlan.getTime().compareTo(endTime)>=0)
                    return true;
            }
        }
        return false;
    }


    public void cancelBookingById(String bookingID) /*throws BookingFailedException*/ {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("Delete from FlipFit.Booking where bookingId = ?");
            stmt.setString(1, bookingID);
            stmt.executeUpdate();
        } catch(SQLException sql) {
            //throw new BookingFailedException("Could not cancel booking for BookingId: " + bookingID);
        } catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    public FlipfitBookingList getBookingByBookingId(String bookingId) {
    	FlipfitBookingList booking  = null;
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("Select * From FlipFit.Booking where bookingId = ?");
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                booking = new FlipfitBookingList(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

            }
        } catch(SQLException sql) {
            //throw new BookingFailedException("Could not fetch booking by bookingId: " + bookingId);
        } catch(Exception excep) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return booking;
    }
	
}
