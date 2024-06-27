package com.flipkart.dao;
import com.flipkart.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.utils.DBConnection;

public class FlipfitCustomerDAOImpl implements FlipfitCustomerDAOInterface {
	public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber){
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FlipFit.GymCentre (userId,userName,password,email,phoneNumber,cardNumber) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, cardNumber);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
//            throw new RegistrationFailedException("Failed to register the user. Try again.");
        } catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    public boolean isUserValid(String userName, String password)  {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFit.Customer WHERE name = ? AND password = ?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                stmt.close();
                return true;
            }
            stmt.close();
        } catch (SQLException exp) {
//            throw new UserInvalidException("User is Invalid. Try again.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return false;
    }

    public FlipfitCustomer getCustomerById(String userName) {
        FlipfitCustomer customer = new FlipfitCustomer();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFit.Customer WHERE name = ?");
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            customer.setEmail(rs.getString("email"));
            customer.setUserID(rs.getString("Id"));
            customer.setPassword(rs.getString("password"));
            customer.setUserName(rs.getString("name"));
            customer.setCustomerPhone(rs.getString("phone"));
            customer.setCardDetails(rs.getString("cardDetails"));

            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return customer;
    }
}
