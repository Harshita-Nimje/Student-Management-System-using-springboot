package com.example.demo.service.impl;

import com.example.demo.dto.core.CustomerDto;
import com.example.demo.dto.request.RequestCustomerDto;
import com.example.demo.dto.response.ResponseCustomerDto;
import com.example.demo.dto.response.paginated.model.CustomerPaginatedDto;
import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/12/2024
 * @project : demo
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {

        CustomerDto customerDto = new CustomerDto(
                0,
                new Random().nextInt(100001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null

        );

        Customer customer = new Customer(
                0,
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState(),
                null


        );


        customerRepo.save(customer);
        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()

        );
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        return null;
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id) {
        return null;
    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText) {
        return null;
    }
}
