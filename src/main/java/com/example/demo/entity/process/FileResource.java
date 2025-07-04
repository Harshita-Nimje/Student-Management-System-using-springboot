package com.example.demo.entity.process;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileResource {

    @Column(columnDefinition = "LONGBLOB")
    private Blob fileName;
    @Column(columnDefinition = "LONGBLOB")
    private Blob resourceUrl;
    @Column(columnDefinition = "LONGBLOB")
    private Blob directory;
    @Column(columnDefinition = "LONGBLOB")
    private Blob hash;
}
