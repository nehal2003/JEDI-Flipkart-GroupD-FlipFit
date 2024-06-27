/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.List;

/**
 * 
 */
public class FlipfitGymCentreBusiness implements FlipfitGymCentreInterface {
	private static FlipfitGymCentreDAOInterface gymCentreDAO = new FlipfitGymCentreDAOImpl();
    private static ScheduleInterface scheduleService = new ScheduleBusiness();

    public List<FlipfitGymInformation> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwmerId(gymOwnerId);
    }

    public List<FlipfitGymInformation> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    public List<SlotDetails> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public FlipfitGymInformation addCenter(FlipfitGymInformation gymCentre) {
        //takes gymCenter details
        return gymCentreDAO.addGymCentre(gymCentre);

    }

    public boolean isValdidCentre(String centreID){
        if(getGymCentreById(centreID) == null) return false;
        return true;

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public FlipfitGymInformation getGymCentreById(String centreID) {
    	FlipfitGymInformation gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}
