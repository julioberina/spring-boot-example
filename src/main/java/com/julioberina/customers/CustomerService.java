package com.julioberina.customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public Customer getCustomer(Integer id) {
        return customerDao.getCustomer(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    public Customer updateCustomer(Integer id, Customer customer) {
        return customerDao.updateCustomer(id, customer);
    }

    public Customer deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }
}
