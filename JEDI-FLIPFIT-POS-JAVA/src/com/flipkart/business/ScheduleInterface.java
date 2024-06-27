/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.ScheduleBooking;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.List;

/**
 * 
 */
public interface ScheduleInterface {
	ScheduleBooking createSchedule(Date date, String slotId);
	ScheduleBooking getScheduleByDateAndSlotId(String SlotId, Date date);
    boolean modifySchedule(String scheduleId,int action);
    List<ScheduleBooking> checkAvailability(String centreID, Date date);
    List<SlotDetails> getAllAvailableSlotsByDate(String centreID, Date date);
    ScheduleBooking getOrCreateSchedule(String slotId, Date date);

}
