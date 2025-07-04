package com.example.demo.service;

import com.example.demo.dto.request.RequestCustomerDto;
import com.example.demo.dto.response.ResponseCustomerDto;
import com.example.demo.dto.response.paginated.model.CustomerPaginatedDto;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/12/2024
 * @project : demo
 */
public interface CustomerService {
    public  ResponseCustomerDto createCustomer(RequestCustomerDto dto);
    public  ResponseCustomerDto findCustomer(long id);
    public  ResponseCustomerDto updateCustomer(RequestCustomerDto dto,long id);
    public  void deleteCustomer(long id);
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText);


}
