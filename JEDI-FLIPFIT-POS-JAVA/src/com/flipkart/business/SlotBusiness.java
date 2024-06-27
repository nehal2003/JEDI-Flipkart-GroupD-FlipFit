/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.SlotDetails;
import com.flipkart.utils.AddSlotDTO;

import java.util.List;

/**
 * 
 */
public class SlotBusiness implements SlotInterface {
	private static SlotDAOImpl slotDAO = new SlotDAOImpl();
    private FlipfitGymCentreInterface gymCentreService = new FlipfitGymCentreBusiness();
    public List<SlotDetails> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public SlotDetails getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    public SlotDetails getSlotByIDandCentreId(String slotID, String centreId){
        return slotDAO.getSlotByIdAndCentreId(slotID,centreId);
    }

    public List<SlotDetails> getSlotList(){
        return slotDAO.getSlotList();
    }

public void addSlotListForGym(String gymCentreId, List<AddSlotDTO> slotList) {
    System.out.println("Adding all slots to gym: " + gymCentreId);

    slotList.stream()
            .filter(slot -> !gymCentreService.isValdidCentre(gymCentreId))
            .forEach(slot -> slotDAO.addSlot(slot.getSlotId(), slot.getCentreID(), slot.getTime()));
}


    public boolean isSlotValid(String slotID,String centreId){
        return getSlotByIDandCentreId(slotID,centreId) != null;
    }

}
