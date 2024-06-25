/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class FlipfitGymInformation {
	private Integer gymID;
	private String gymName;
	private String gymAddress;
	private Integer gymOwnerID;
	
	public Integer getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(Integer gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	public Integer getGymID() {
		return gymID;
	}
	public void setGymID(Integer gymID) {
		this.gymID = gymID;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymAddress() {
		return gymAddress;
	}
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}
}
