package com.flipkart.business;
import com.flipkart.bean.Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerBusiness1 {
    private List<Customer> customers = new ArrayList<>();


    public void createCustomer() {
        System.out.println("Creating Customers...");

        Customer customer1 = new Customer();
        customer1.setCustomerId(101);
        customer1.setCustomerName("xyz");
        customer1.setCustomerAddress("Bangalore");

        Customer customer2 = new Customer();
        customer2.setCustomerId(102);
        customer2.setCustomerName("axyz");
        customer2.setCustomerAddress("Bangalore");

        Customer customer3 = new Customer();
        customer3.setCustomerId(103);
        customer3.setCustomerName("bxyz");
        customer3.setCustomerAddress("Bangalore");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("Customers created successfully.");
    }


    public boolean updateCustomer(int customerId) {
        System.out.println("Updating customer with ID: " + customerId);
        for (Customer cust : customers) {
            if (cust.getCustomerId() == customerId) {
                // Perform update operation (for demonstration, let's update name)
                cust.setCustomerName("Updated Name");
                return true;
            }
        }
        System.out.println("Customer with ID " + customerId + " not found.");
        return false;
    }

    public boolean deleteCustomer(int customerId) {
        System.out.println("Deleting customer with ID: " + customerId);
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer cust = iterator.next();
            if (cust.getCustomerId() == customerId) {
                iterator.remove(); // Remove the customer from the list
                return true;
            }
        }
        System.out.println("Customer with ID " + customerId + " not found.");
        return false;
    }
    
    public void listCustomer() {
        System.out.println("Listing all customers:");
        for (Customer cust : customers) {
            System.out.println("Customer ID: " + cust.getCustomerId() +
                    ", Name: " + cust.getCustomerName() +
                    ", Address: " + cust.getCustomerAddress());
        }
    }
}
