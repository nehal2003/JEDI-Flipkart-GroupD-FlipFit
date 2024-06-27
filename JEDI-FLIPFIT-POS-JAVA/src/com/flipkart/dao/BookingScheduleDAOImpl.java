/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkart.bean.ScheduleBooking;
import com.flipkart.utils.DBConnection;

/**
 * 
 */
public class BookingScheduleDAOImpl implements BookingScheduleDAOInterface {

	public void addSchedule( ScheduleBooking schedule){
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO FlipFit.Schedule(scheduleId, date, slotId, availability ) values (?,?,?,?)");
            ps.setString(1, schedule.getScheduleID());
            ps.setDate(2, schedule.getDate());
            ps.setString(3, schedule.getSlotID());
            ps.setInt(4, schedule.getAvailability());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ScheduleBooking getSchedule(String scheduleId){
        ScheduleBooking schedule = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Schedule WHERE scheduleId=?");
            ps.setString(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                Date date = new Date(rs.getDate("date").getTime());
                schedule = new ScheduleBooking(date, slotId, availability);
                schedule.setScheduleID(scheduleId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schedule;
    }

    public List<ScheduleBooking> getAllScheduleByDate(Date date) {
        ArrayList<ScheduleBooking> response = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFit.Schedule WHERE date=?");
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String scheduleId = rs.getString("scheduleId");
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                ScheduleBooking schedule = new ScheduleBooking( date, slotId, availability);
                schedule.setScheduleID(scheduleId);
                response.add(schedule);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public boolean modifySchedule(String scheduleId,int action){
        //1 for increasing, -1 for decreasing
        try{
            Connection conn = DBConnection.connect();
            int availability = getSchedule(scheduleId).getAvailability();
            if(availability < 1 && action == -1){
                return false;
            }
            PreparedStatement ps = conn.prepareStatement("UPDATE `flipfit`.`schedule` SET availability = ? WHERE (`scheduleId` = ?)");
            ps.setInt(1, availability+action);
            ps.setString(2, scheduleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
