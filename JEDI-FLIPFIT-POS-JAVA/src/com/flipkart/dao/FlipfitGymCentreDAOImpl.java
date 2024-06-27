/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.utils.DBConnection;
/**
 * 
 */
public class FlipfitGymCentreDAOImpl implements FlipfitGymCentreDAOInterface {

	 private Connection conn = null;
	    private PreparedStatement statement = null;

	    public FlipfitGymCentreDAOImpl() {
	    }

	    // api call to retrieve all gym centres and status
	    public List<FlipfitGymInformation> getAllCentresByOwnerId(String gymOwnerId)  {

	        List<FlipfitGymInformation> allGymCentres = new ArrayList<>();
	        try {
	            conn = DBConnection.connect();
	            statement = conn.prepareStatement("SELECT * FROM FlipFit.GymCentre where ownerId = ?");
	            statement.setString(1, gymOwnerId);

	            ResultSet rs = statement.executeQuery();
	            while(rs.next()) {
	                FlipfitGymInformation gymCentre = new FlipfitGymInformation(
	                        rs.getString("centreId"),
	                        rs.getString("ownerId"),
	                        rs.getString("centreName"),
	                        rs.getString("gstin"),
	                        rs.getString("city"),
	                        rs.getInt("capacity"),
	                        rs.getInt("price")
	                );
	                gymCentre.setApproved(rs.getInt("isApproved"));
	                allGymCentres.add(gymCentre);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return allGymCentres;
	    }



	    public FlipfitGymInformation getGymCentreByCentreId(String gymCentreId){
	    	FlipfitGymInformation gymCentre = new FlipfitGymInformation();
	        try {
	            Connection conn = DBConnection.connect();
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFit.GymCentre where centreId = ?");
	            stmt.setString(1, gymCentreId);
	            ResultSet rs = stmt.executeQuery();
	            rs.next();
	            gymCentre.setGymCentreID(rs.getString("centreId"));
	            gymCentre.setOwnerID(rs.getString("ownerId"));
	            gymCentre.setGymCenterName(rs.getString("centreName"));
	            gymCentre.setGstin(rs.getString("gstin"));
	            gymCentre.setCity(rs.getString("city"));
	            gymCentre.setCapacity(rs.getInt("capacity"));
	            gymCentre.setPrice(rs.getInt("price"));
	            gymCentre.setApproved(rs.getInt("isApproved"));
	            stmt.close();
	        } catch (SQLException exp) {
	            exp.printStackTrace();
	        }

	        return gymCentre;

	    }

	    public void addGymCentre(FlipfitGymInformation centre) {
	        // call to db api
	        try {
	            conn = DBConnection.connect();
	            System.out.println("Adding gym centre....");

	            //    INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved)
	            statement = conn.prepareStatement("INSERT INTO FlipFit.GymCentre (centreId, ownerId, centreName, gstin, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	            statement.setString(1,centre.getGymCentreID());
	            statement.setString(2,centre.getOwnerID());
	            statement.setString(3, centre.getGymCenterName());
	            statement.setString(4,centre.getGstin());
	            statement.setString(5, centre.getCity());
	            statement.setInt(6, centre.getCapacity());
	            statement.setInt(7, centre.getPrice());
	            statement.setInt(8, centre.isApproved());

	            statement.execute();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<FlipfitGymInformation> getPendingGymCentreList() {
	        List<FlipfitGymInformation> pendingList = new ArrayList<>();
	        try {
	            conn = DBConnection.connect();
	            System.out.println("Fetching gym centres..");

	            statement = conn.prepareStatement("SELECT * FROM FlipFit.GymCentre where isApproved = 2");

	            ResultSet rs = statement.executeQuery();
	            while(rs.next()) {
	                FlipfitGymInformation gymCentre = new FlipfitGymInformation(
	                        rs.getString("centreId"),
	                        rs.getString("ownerId"),
	                        rs.getString("centreName"),
	                        rs.getString("gstin"),
	                        rs.getString("city"),
	                        rs.getInt("capacity"),
	                        rs.getInt("price")
	                );
	                gymCentre.setApproved(rs.getInt("isApproved"));
	                pendingList.add(gymCentre);
	            }
	            //conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return pendingList;
	    }

	    public void validateGymCentre(String gymCentreId, int isApproved) {
//	        System.out.println("IN VALIDATE GYM CENTRE");
	        try {
	            conn = DBConnection.connect();
	            System.out.println("Fetching gyms centres..");

	            statement = conn.prepareStatement("Update GymCentre Set isApproved=? WHERE centreId=?");
	            statement.setInt(1, isApproved);
	            statement.setString(2, gymCentreId);
	            statement.executeUpdate();
//	            System.out.println("The gym centre has been approved!");
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        }
//	        for(GymCentre gymCentre : gymCentreList) {
//	            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//	                gymCentre.setApproved(isApproved);
//	            }
//	        }
//	        for(GymCentre gymCentre : pendingGymCentreList) {
//	            if(gymCentre.getGymCentreID().equals(gymCentreId)) {
//	                pendingGymCentreList.remove(gymCentre);
//	            }
//	        }
	    }

	    public void sendCentreApprovalRequest(String gymCentreId){
	        try {
	            conn = DBConnection.connect();
	            System.out.println("Sending gym centre approval request..");
	            // SQL_APPROVE_GYM_CENTRE_BY_ID_QUERY="Update GymCentre Set isApproved=? WHERE centreId=?";
	            statement = conn.prepareStatement("Update GymOwner Set isApproved=? WHERE Id=?");
	            statement.setInt(1,2);
	            statement.setString(2, gymCentreId);
	            statement.executeUpdate();

	        } catch (SQLException se) { se.printStackTrace(); }
	        catch (Exception e) { e.printStackTrace(); }
	    }

	    public List<FlipfitGymInformation> getGymCentreListByCity(String city) {
	        List<FlipfitGymInformation> allCentreByCity = new ArrayList<>();
	        try {
	            conn = DBConnection.connect();
	            System.out.println("Fetching gyms centres by City..");
	            statement = conn.prepareStatement("SELECT * FROM FlipFit.GymCentre where city = ?");
	            statement.setString(1, city);
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()) {
	            	FlipfitGymInformation gymCentre = new FlipfitGymInformation(
	                        rs.getString("centreId"),
	                        rs.getString("ownerId"),
	                        rs.getString("centreName"),
	                        rs.getString("gstin"),
	                        rs.getString("city"),
	                        rs.getInt("capacity"),
	                        rs.getInt("price")
	                );
	                allCentreByCity.add(gymCentre);
	            }
	            //System.out.println("The gym centre has been approved!");
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        }
//	        for(GymCentre gymCentre: gymCentreList){
//	            if(gymCentre.getCity().equals(city)){
//	                allCentreByCity.add(gymCentre);
//	            }
//	        }
	        return allCentreByCity;
	    }

}
