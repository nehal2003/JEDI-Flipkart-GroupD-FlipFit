/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class SlotDAOImpl {
	public List<SlotDetails> getSlotList() {
        List<SlotDetails> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Slot");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new SlotDetails(slotId, centreId, time));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public List<SlotDetails> getSlotByCentreId(String gymCentreId){
        List<SlotDetails> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Slot WHERE centreId=?");
            ps.setString(1,gymCentreId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new SlotDetails(slotId, centreId, time));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public void addSlot(SlotDetails slot){
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO FlipFit.Slot(slotId, centreId, time) values (?, ?, ?)");
            ps.setString(1, slot.getSlotId());
            ps.setString(2, slot.getCentreID());
            ps.setTime(3, java.sql.Time.valueOf(slot.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SlotDetails getSlotById(String slotID) {
        SlotDetails slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Slot WHERE slotId=?");
            ps.setString(1,slotID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new SlotDetails(slotID, centreId, time);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }

    public SlotDetails getSlotByIdAndCentreId(String slotID,String centreID) {
        SlotDetails slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Slot WHERE slotId=? AND centreId=?");
            ps.setString(1,slotID);
            ps.setString(2,centreID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new SlotDetails(slotID, centreID, time);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }
}
