package com.example.demo.entity;

import com.example.demo.entity.process.FileResource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/12/2024
 * @project : demo
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long publicId;
    private String name;
    private String address;
    private double salary;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    @Embedded
    private FileResource fileResource;


}
