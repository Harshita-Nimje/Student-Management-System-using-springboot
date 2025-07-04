package com.example.demo.dto.response.paginated.model;

import com.example.demo.dto.response.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Vishnuka Yahan
 *
 * @author : Vishnuka Yahan
 * @data : 2/12/2024
 * @project : demo
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerPaginatedDto {

    private long dataCount;
    private List<ResponseCustomerDto> list;
}
