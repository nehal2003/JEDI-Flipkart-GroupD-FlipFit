/**
 * 
 */
package com.flipkart.dao;

import java.util.List;
import com.flipkart.bean.*;

/**
 * 
 */
public interface SlotDAOInterface {
	
	List<SlotDetails> getSlotList();

    List<SlotDetails> getSlotByCentreId(String gymCentreId);

    void addSlot(SlotDetails slot);

    SlotDetails getSlotById(String slotID);

    SlotDetails getSlotByIdAndCentreId(String slotID, String gymCentreId);
    
}
