/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Sale;
import com.wismo.demo.service.SaleService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/sale")
public class SaleController {
    
    @Autowired
    private SaleService saleService;
    
    @PostMapping
    private ResponseEntity<?> create(@RequestBody Sale sale){
        try {
            return ResponseEntity.ok().body(saleService.save(sale));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    @GetMapping
    private ResponseEntity<?> readAll(){
        List<Sale> sales =  saleService.findAll();
        sales.size();
        
        return ResponseEntity.ok().body(sales);
    }
    
    
    @GetMapping("/{id}")
    private ResponseEntity<?> readOne(@PathVariable Long id){
        Optional<Sale> oSale = saleService.findById(id);
        
        if (!oSale.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(oSale);
    }
    
    
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Sale newSale){
        Optional<Sale> oSale = saleService.findById(id);
        
        if (!oSale.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        oSale.get().setTotal_sale(newSale.getTotal_sale());
        oSale.get().setSale_date(newSale.getSale_date());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(oSale.get()));
    }
    
    
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        if (!saleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        saleService.deleteById(id);
        
        return ResponseEntity.ok().build();  
    }
    
    @PutMapping("/{id}/item/{id_Item}")
    private ResponseEntity<?> addSaleItem(@PathVariable Long id, @PathVariable Long id_Item){
        Optional<Sale> oSale = saleService.findById(id);
        
        if (!oSale.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        oSale.get().getItems().size();
        
        oSale.get().getItems().add(saleService.getItem(id_Item));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(oSale.get()));
    }
    
    
    @DeleteMapping("/{id}/item/{id_Item}")
    private ResponseEntity<?> removeSaleItem(@PathVariable Long id, @PathVariable Long id_Item){
        Optional<Sale> oSale = saleService.findById(id);
        
        if (!oSale.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        oSale.get().getItems().size();
        
        oSale.get().getItems().remove(saleService.getItem(id_Item));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(oSale.get()));
    }
}
