/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.SlotDetails;

import java.sql.Date;
import java.util.List;

/**
 * 
 */
public interface FlipfitGymCentreInterface {
	List<FlipfitGymInformation> getAllCentresByOwmerId(String gymOwnerId);
    List<FlipfitGymInformation> getCentresByCity(String city);
    List<SlotDetails> getAvailableSlotsByCentreAndDate(String centreID, Date date);
//    FlipfitGymInformation addCenter(FlipfitGymInformation gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    FlipfitGymInformation getGymCentreById(String centreID);
    boolean isValdidCentre(String centreID);
}
