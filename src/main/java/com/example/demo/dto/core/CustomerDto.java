package com.example.demo.dto.core;

import lombok.*;

import java.sql.Blob;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/10/2024
 * @project : demo
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private long id;
    private long publicId;
    private String name;
    private String address;
    private double salary;

    private boolean activeState;

    /*---------------------------*/
    private Blob fileName;
    private Blob resourceUrl;
    private Blob directory;
    private Blob hash;
    /*---------------------------*/


}
