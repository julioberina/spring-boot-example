package com.julioberina.customers;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    private Integer customerCount = 0;
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(Integer id) {
        return findCustomerById(id);
    }

    public Customer createCustomer(Customer customer) {
        customer.setId(++customerCount);
        customers.add(customer);
        return customer;
    }

    public Customer updateCustomer(Integer id, Customer customer) {
        Customer updateCustomer = findCustomerById(id);

        updateCustomer.setName(Optional.ofNullable(customer.getName()).orElse(updateCustomer.getName()));
        updateCustomer.setAge(Optional.ofNullable(customer.getAge()).orElse(updateCustomer.getAge()));
        updateCustomer.setEmail(Optional.ofNullable(customer.getEmail()).orElse(updateCustomer.getEmail()));

        return updateCustomer;
    }

    public Customer deleteCustomer(Integer id) {
        Customer deleteCustomer = findCustomerById(id);

        customers = customers.stream()
                .filter(customer -> !customer.getId().equals(deleteCustomer.getId()))
                .collect(Collectors.toCollection(ArrayList::new));

        return deleteCustomer;
    }

    private Customer findCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
