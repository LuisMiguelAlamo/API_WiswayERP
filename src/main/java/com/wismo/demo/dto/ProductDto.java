/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wismo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Miguel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    
    private Long id;
    
    private String name;
    
    private Float price;
    
    private Boolean active;
}
