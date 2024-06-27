/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.FlipfitGymOwner;

import java.util.List;

/**
 * 
 */
public interface FlipfitGymOwnerInterface {
	void requestGymOwnerApproval(String gymOwnerId);
    List<FlipfitGymOwner> viewAllGymOwners();
    FlipfitGymOwner loginGymOwner(String userId, String password);
//    FlipfitGymOwner registerGymOwner(FlipfitGymOwner gymOwner);

}
