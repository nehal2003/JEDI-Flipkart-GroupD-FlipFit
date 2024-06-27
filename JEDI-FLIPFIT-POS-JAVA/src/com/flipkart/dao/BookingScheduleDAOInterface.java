/**
 * 
 */
package com.flipkart.dao;
import java.util.Date;
import java.util.List;

import com.flipkart.bean.*;
/**
 * 
 */
public interface BookingScheduleDAOInterface {
	public void addSchedule(ScheduleBooking schedule);
    public List<ScheduleBooking> getAllScheduleByDate(Date date);
}
