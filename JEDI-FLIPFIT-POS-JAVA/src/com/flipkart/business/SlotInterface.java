/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.SlotDetails;
import com.flipkart.utils.AddSlotDTO;

import java.util.List;
/**
 * 
 */
public interface SlotInterface {
	List<SlotDetails> getAllSlotsByCentre(String centreID);
    SlotDetails getSlotByID(String slotID);
    List<SlotDetails> getSlotList();
//    void addSlotListForGym(String gymCentreId, List<Slot> slotList);
    void addSlotListForGym(String gymCentreId, List<AddSlotDTO> slotList);
    boolean isSlotValid(String slotID,String centreId);

}
