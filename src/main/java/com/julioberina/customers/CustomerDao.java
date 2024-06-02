package com.julioberina.customers;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();
    public Customer getCustomer(Integer id);
    public Boolean createCustomer(Customer customer);
    public Boolean updateCustomer(Integer id, Customer customer);
    public Boolean deleteCustomer(Integer id);
}
