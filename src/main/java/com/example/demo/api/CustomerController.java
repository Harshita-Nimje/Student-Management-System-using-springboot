package com.example.demo.api;

import com.example.demo.db.Database;
import com.example.demo.dto.request.RequestCustomerDto;
import com.example.demo.service.CustomerService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @date : 2/9/2024
 * @project : demo
 */

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(
            @RequestBody RequestCustomerDto customerDto
    ) {
        var savedData = customerService.createCustomer(customerDto); // fixed
        return new ResponseEntity<>(
                new StandardResponse(201, "customer Saved!", savedData),
                HttpStatus.CREATED
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCustomer(
            @RequestParam int id,
            @RequestBody RequestCustomerDto customerDto
    ) throws ClassNotFoundException {

        var savedData = Database.updateCustomer(customerDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "customer updated!!", savedData),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteCustomer(
            @RequestParam int id
    ) throws ClassNotFoundException {
        Database.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "customer deleted!!", null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "customer Data!", Database.findCustomer(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/list", params = {"page", "size", "searchText"})
    public ResponseEntity<StandardResponse> getAllCustomer(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText
    ) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "customer List!", Database.searchAllCustomer(page, size, searchText)),
                HttpStatus.OK
        );
    }
}
