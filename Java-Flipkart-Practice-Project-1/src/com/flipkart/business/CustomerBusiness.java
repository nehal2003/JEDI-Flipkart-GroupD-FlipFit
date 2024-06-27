package com.flipkart.business;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBusiness implements CustomerBusinessInterface{

    //add //update // delete // list

    Customer cust[] = new Customer[3];
    //List<String> list =new ArrayList<String>();
    public void createCustomer()
    {
        System.out.println("Creating a new customer.");
        cust[0] = new Customer();
        cust[0].setCustomerId(101);
        cust[0].setCustomerAddress("Bangalore");
        cust[0].setCustomerName("Mohit");
        cust[1] = new Customer();
        cust[1].setCustomerId(102);
        cust[1].setCustomerAddress("Bangalore");
        cust[1].setCustomerName("Rohit");
        cust[2] = new Customer();
        cust[2].setCustomerId(103);
        cust[2].setCustomerAddress("Bangalore");
        cust[2].setCustomerName("Sohit");
        listCustomer();
    }


    public boolean updateCustomer(int id,String name,String address)
    {
        System.out.println("Updating a new customer.");
        int ind=-1;
        for(int i = 0; i < cust.length; i++)
        {
            if(cust[i].getCustomerId() == id)
            {
                cust[i].setCustomerAddress(address);
                cust[i].setCustomerName(name);
                break;
            }
        }
        listCustomer();
        return true;
    }

    public boolean deleteCustomer(int id)
    {
        System.out.println("Deleting a customer.");
        int ind = -1;
        for(int i = 0; i < cust.length; i++)
        {
            if(cust[i].getCustomerId() == id)
            {
                cust[i] = null;
                break;
            }
        }
        listCustomer();
        return true;
    }

    public void listCustomer()
    {
        System.out.println("Listing all customers.");
        for(int i = 0; i < cust.length; i++)
        {
            if(cust[i]!=null)
            {
                System.out.print(cust[i].getCustomerId());
                System.out.print(cust[i].getCustomerName());
                System.out.println(cust[i].getCustomerAddress());
            }
        }
    }
}