/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Purchase;
import com.wismo.demo.service.PurchaseService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Miguel
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    
    @Autowired
    private PurchaseService purchaseService;
    
    @PostMapping
    private ResponseEntity<?> create(@RequestBody Purchase purchase){
        try {
            
            return ResponseEntity.ok().body(purchaseService.save(purchase));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    private ResponseEntity<?> readAll(){
        try {
            List<Purchase> purchases = (List) purchaseService.findAll();

            return ResponseEntity.ok().body(purchases);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<?> readOne(@PathVariable Long id){
        try {
            Optional<Purchase> oPurchase = purchaseService.findById(id);

            if (!oPurchase.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(oPurchase);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Purchase newPurchase){
        try {
            Optional<Purchase> oPurchase = purchaseService.findById(id);

            if (!oPurchase.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            oPurchase.get().setPurchase_total(newPurchase.getPurchase_total());
            oPurchase.get().setPurhcase_date(newPurchase.getPurhcase_date());

            return ResponseEntity.ok().body(oPurchase);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Optional<Purchase> oPurchase = purchaseService.findById(id);
            
            if (!oPurchase.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            purchaseService.deleteById(id);

            return ResponseEntity.ok().body(oPurchase); 
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
