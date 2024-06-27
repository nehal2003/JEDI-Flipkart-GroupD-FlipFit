/**
 * 
 */
package com.flipkart.dao;
import com.flipkart.bean.*;

import java.util.List;

/**
 * 
 */
public interface FlipfitGymCentreDAOInterface {
	
	public List<FlipfitGymInformation> getAllCentresByOwnerId(String gymOwnerId);

    public FlipfitGymInformation getGymCentreByCentreId(String gymCentreId);

    public void addGymCentre(FlipfitGymInformation centre);

    public List<FlipfitGymInformation> getPendingGymCentreList();

    public void validateGymCentre(String gymCentreId, int isApproved);

    public void sendCentreApprovalRequest(String gymCentreId);

    public List<FlipfitGymInformation> getGymCentreListByCity(String city);
    
}
