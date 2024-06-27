/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.FlipfitGymOwner;

/**
 * 
 */
public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface{
	
    private static FlipfitGymOwnerDAOInterface gymOwnerDAO = new FlipfitGymOwnerDAOImpl();
    private static FlipfitGymCentreDAOInterface gymCentreDAO = new FlipfitGymCentreDAOImpl();

    public List<FlipfitGymOwner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, int isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
        gymCentreDAO.validateGymCentre(gymCentreId,isApproved);
    }

    public List<FlipfitGymInformation> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }
}
