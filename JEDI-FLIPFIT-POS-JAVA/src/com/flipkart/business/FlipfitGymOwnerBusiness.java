/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipfitGymOwner;
import java.util.List;

public class FlipfitGymOwnerBusiness implements FlipfitGymOwnerInterface{
	private static FlipfitGymOwnerDAOInterface gymOwnerDAO = new FlipfitGymOwnerDAOImpl();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);
    }

    public List<FlipfitGymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }


//    public Object addGymOwnerDetails() {
//        //takes gymOwner object as input
//        return new Object();
//    }

    public FlipfitGymOwner loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public FlipfitGymOwner registerGymOwner(FlipfitGymOwner gymOwner) {
        return gymOwnerDAO.registerGymOwner(gymOwner);
    }
}
