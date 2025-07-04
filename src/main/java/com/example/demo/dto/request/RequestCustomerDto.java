package com.example.demo.dto.request;

import lombok.*;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/9/2024
 * @project : demo
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestCustomerDto {

    private String name;
    private String address;
    private double salary;
}
