/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Product;
import com.wismo.demo.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RestController
@RequestMapping("api/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> readAll(){
        try {
            List<Product> products = productService.findAll();
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> readOne(@PathVariable Long id){
        try {
            Optional<Product> oProduct = productService.findById(id);
            
            if (!oProduct.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok().body(oProduct);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    
    @CrossOrigin(origins = "*")
    @PostMapping
    public  ResponseEntity<?> create(@RequestBody Product product){
        try {
            
            return ResponseEntity.ok().body(productService.save(product));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product){
        try {
            Optional<Product> oProduct = productService.findById(id);
            
            if (!oProduct.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            oProduct.get().setName(product.getName());
            oProduct.get().setPrice(product.getPrice());
            oProduct.get().setActive(product.getActive());
            
            return ResponseEntity.ok().body(productService.save(oProduct.get()));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            
            Optional<Product> oProduct = productService.findById(id);
            
            if (!oProduct.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            productService.deleteById(id);
            
            return ResponseEntity.ok().body(oProduct);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
