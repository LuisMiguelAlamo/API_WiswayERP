/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.repository;

import com.wismo.demo.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Miguel
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    
}
