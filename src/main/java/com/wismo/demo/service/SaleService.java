/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Item;
import com.wismo.demo.entity.Sale;


/**
 *
 * @author Luis Miguel
 */
public interface SaleService extends BaseService<Sale, Long>{
    public Item getItem(Long id);
}
