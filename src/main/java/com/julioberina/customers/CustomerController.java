package com.julioberina.customers;

import com.julioberina.Main;
import com.julioberina.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;
    private final Main.Foo foo;

    public CustomerController(CustomerService customerService,
                              Main.Foo foo) {
        this.customerService = customerService;
        this.foo = foo;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Customer>>> getCustomers() {
        ApiResponse<List<Customer>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                customerService.getCustomers()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable int id) {
        ApiResponse<Customer> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                customerService.getCustomer(id)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody Customer customer) {
        ApiResponse<Customer> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                customerService.createCustomer(customer)
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        ApiResponse<Customer> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                customerService.updateCustomer(id, customer)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Customer>> deleteCustomer(@PathVariable int id) {
        ApiResponse<Customer> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                customerService.deleteCustomer(id)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("foo")
    public ResponseEntity<ApiResponse<String>> getCustomerFoo() {
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                foo.getFoo()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
