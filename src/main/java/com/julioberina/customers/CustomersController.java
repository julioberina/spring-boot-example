package com.julioberina.customers;

import com.julioberina.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "customers", produces = "application/json")
public class CustomersController {

    public static class Customer {
        public Integer id;
        public String name;
        public Integer age;
        public String email;
    };

    private List<Customer> customers = new ArrayList<>();
    private Integer customerCount = 0;

    @GetMapping()
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable int id) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.id == id)
                .findFirst();

        ApiResponse<Customer> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Customer " + (customer.isPresent() ? "found!" : "not found!"),
                customer.orElse(null)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Boolean>> createCustomer(@RequestBody Customer customer) {
        customer.id = ++customerCount;
        customers.add(customer);

        ApiResponse<Boolean> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Customer created successfully!",
                true
        );

        return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Boolean>> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Customer updateCustomer = customers.stream()
                .filter(c -> c.id == id)
                .findFirst()
                .orElseThrow();

        updateCustomer.name = Optional.ofNullable(customer.name).orElse(updateCustomer.name);
        updateCustomer.age = Optional.ofNullable(customer.age).orElse(updateCustomer.age);
        updateCustomer.email = Optional.ofNullable(customer.email).orElse(updateCustomer.email);

        ApiResponse<Boolean> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Customer updated successfully!",
                true
        );

        return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteCustomer(@PathVariable int id) {
        customers = customers.stream()
                .filter(customer -> customer.id != id)
                .collect(Collectors.toCollection(ArrayList::new));

        ApiResponse<Boolean> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Customer deleted successfully!",
                true
        );

        return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.OK);
    }
}
