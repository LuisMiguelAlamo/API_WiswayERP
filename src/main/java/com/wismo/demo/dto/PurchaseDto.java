/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.dto;

import java.sql.Date;
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
public class PurchaseDto {
    
    private Long id;
    
    private Float purchase_total;
    
    private Date purhcase_date;
}
