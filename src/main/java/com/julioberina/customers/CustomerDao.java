package com.julioberina.customers;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();
    public Customer getCustomer(Integer id);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Integer id, Customer customer);
    public Customer deleteCustomer(Integer id);
}
