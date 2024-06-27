/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.FlipfitGymInformation;
import com.flipkart.bean.FlipfitGymOwner;

import java.util.List;

/**
 * 
 */
public interface FlipfitAdminInterface {
	
	/**
     * Approves or disapproves a gym center based on the provided gym center ID and approval status.
     *
     * @param gymCentreId The ID of the gym center to be approved or disapproved
     * @param isApproved  The approval status (1 for approved, 0 for not approved)
     */
    void approveGymCenter(String gymCentreId, int isApproved);

    /**
     * Approves or disapproves a gym owner based on the provided gym owner ID and approval status.
     *
     * @param gymOwnerId The ID of the gym owner to be approved or disapproved
     * @param isApproved The approval status (1 for approved, 0 for not approved)
     */
    void approveGymOwner(String gymOwnerId, int isApproved);

    /**
     * Retrieves a list of pending gym centers awaiting approval.
     *
     * @return List of pending gym centers
     */
    List<FlipfitGymInformation> viewPendingGymCentres();

    /**
     * Retrieves a list of pending gym owners awaiting approval.
     *
     * @return List of pending gym owners
     */
    List<FlipfitGymOwner> viewPendingGymOwners();
}
