package com.example.demo.db;

import com.example.demo.dto.core.CustomerDto;
import com.example.demo.dto.request.RequestCustomerDto;
import com.example.demo.dto.response.ResponseCustomerDto;
import com.example.demo.dto.response.paginated.model.CustomerPaginatedDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/9/2024
 * @project : demo
 */
public class Database {

    public static ArrayList<CustomerDto> customerTable = new ArrayList<>();



    public static ResponseCustomerDto findCustomer(int id) throws ClassNotFoundException {

        Optional<CustomerDto> selectedCustomer = customerTable.stream()
                .filter(e -> e.getPublicId() == id)
                .findFirst();




        if (selectedCustomer.isPresent()){
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()

            );
        }
        throw new ClassNotFoundException();

    }


    public static ResponseCustomerDto updateCustomer(RequestCustomerDto dto,int id) throws ClassNotFoundException {

        Optional<CustomerDto> selectedCustomer =
                customerTable.stream().filter(e -> e.getPublicId()==id).findFirst();



        if (selectedCustomer.isPresent()){
                    selectedCustomer.get().setName(dto.getName());
                    selectedCustomer.get().setAddress(dto.getAddress());
                    selectedCustomer.get().setSalary(dto.getSalary());

            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()

            );
        }
        throw new ClassNotFoundException();
    }


    public static void deleteCustomer(int id) throws ClassNotFoundException {
        Optional<CustomerDto> selectedCustomer =
                customerTable.stream().filter(e -> e.getPublicId()==id).findFirst();

        if (selectedCustomer.isPresent()){
            customerTable.remove(selectedCustomer.get());
            return;
        }
        throw new ClassNotFoundException();

    }

    public static CustomerPaginatedDto searchAllCustomer(int page,int size, String searchText) throws ClassNotFoundException {
        List<ResponseCustomerDto> list = new ArrayList<>();
        for (CustomerDto  d: customerTable) {
            list.add(new ResponseCustomerDto(

                    d.getPublicId(),
                    d.getName(),
                    d.getAddress(),
                    d.getSalary(),
                    d.isActiveState()
            ));
        }

        return new CustomerPaginatedDto(customerTable.size(),list);
    }


}
