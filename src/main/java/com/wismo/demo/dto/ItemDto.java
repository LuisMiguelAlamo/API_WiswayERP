/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ItemDto {
    
    private Long id;
    
    private String name;
    
    private Float price;
    
    private Boolean active;
}
