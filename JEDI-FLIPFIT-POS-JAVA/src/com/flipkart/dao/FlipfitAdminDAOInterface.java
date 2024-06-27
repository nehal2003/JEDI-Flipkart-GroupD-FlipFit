package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.*;

public interface FlipfitAdminDAOInterface {

    public List<FlipfitGymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, int isApproved);
    public void validateGymCentre(String gymCentreId, int isApproved);
    public List<FlipfitGymInformation> getPendingGymCentres();
}