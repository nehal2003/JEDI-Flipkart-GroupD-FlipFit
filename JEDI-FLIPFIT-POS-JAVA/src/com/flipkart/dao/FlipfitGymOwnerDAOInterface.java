package com.flipkart.dao;
import com.flipkart.bean.FlipfitGymOwner;
import java.util.List;

public interface FlipfitGymOwnerDAOInterface {
	
	public List<FlipfitGymOwner> getGymOwnerList();
    public void setGymOwnerList(List<FlipfitGymOwner> gymOwnerList);
    public void registerGymOwner(FlipfitGymOwner gymOwner);
    public List<FlipfitGymOwner> getPendingGymOwnerList();
    public void sendOwnerApprovalRequest(String gymOwnerId);
    public void setPendingGymOwnerList();
    public void validateGymOwner(String gymOwnerId, int isApproved);
}
