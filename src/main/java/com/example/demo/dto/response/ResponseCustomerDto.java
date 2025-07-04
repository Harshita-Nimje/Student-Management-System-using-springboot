package com.example.demo.dto.response;

import lombok.*;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/9/2024
 * @project : demo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseCustomerDto {
    private long publicId;

    private String name;
    private String address;
    private double salary;

    private boolean activeState;

}
