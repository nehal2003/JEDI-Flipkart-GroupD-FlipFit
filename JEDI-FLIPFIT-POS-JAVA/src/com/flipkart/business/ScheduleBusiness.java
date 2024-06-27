/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.ScheduleBooking;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 */
public class ScheduleBusiness implements ScheduleInterface {
	private FlipfitGymCentreBusiness gymCentreService = new FlipfitGymCentreBusiness();
    private SlotBusiness slotService = new SlotBusiness();
    private BookingScheduleDAOImpl scheduleDAO = new BookingScheduleDAOImpl();

    public ScheduleBooking createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCentreID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        ScheduleBooking schedule = new ScheduleBooking( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    public ScheduleBooking getScheduleByDateAndSlotId(String SlotId, Date date) {
        List<ScheduleBooking> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        return scheduleList.stream()
                .filter(schedule -> schedule.getSlotID().equals(SlotId))
                .findFirst()
                .orElse(null);
    }


    public boolean modifySchedule(String scheduleId,int action){
        // increment or decrement availability based on action
        // 1 for increasing availability, -1 for decreasing
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<ScheduleBooking> checkAvailability(String centreID, Date date) {
        List<SlotDetails> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        return allSlotsForGym.stream()
                .map(slot -> getOrCreateSchedule(slot.getSlotId(), date))
                .filter(schedule -> schedule.getAvailability() > 0)
                .collect(Collectors.toList());
    }


    public List<SlotDetails> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<SlotDetails> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        return allSlotsOfThatCentre.stream()
                .filter(slot -> scheduleDAO.getAllScheduleByDate(date).stream()
                        .anyMatch(schedule ->
                                slotService.getSlotByID(schedule.getSlotID()).getCentreID().equals(centreID) &&
                                        schedule.getAvailability() > 0
                        )
                )
                .collect(Collectors.toList());
    }


    public ScheduleBooking getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public ScheduleBooking getOrCreateSchedule(String slotId, Date date) {
        ScheduleBooking schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }

}
