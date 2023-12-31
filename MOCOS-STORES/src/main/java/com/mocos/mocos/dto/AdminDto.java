package com.mocos.mocos.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    private String productName;
    private String description;
    private Double price;
    private String duration;


}
