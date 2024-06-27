package com.flipkart.business;
public interface CustomerBusinessInterface {
    public void createCustomer() ;
    public boolean updateCustomer(int id,String name,String address) ;
    public boolean deleteCustomer(int customerId) ;
    public void listCustomer();
}