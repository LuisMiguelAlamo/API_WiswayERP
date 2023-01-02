/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Customer;
import com.wismo.demo.service.CustomerService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Miguel
 */
@RestController
@RequiredArgsConstructor
@ResponseBody
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping
    private ResponseEntity<?> create(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.save(customer));
    }
    
    @GetMapping
    private ResponseEntity<?> readAll(){
        List<Customer> customers = (List)customerService.findAll();
        customers.size();
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<?> readOne(@PathVariable Long id){
        Optional<Customer> oCustomer = customerService.findById(id);
        
        if (!oCustomer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oCustomer);
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> oCustomer = customerService.findById(id);
        
        if (!oCustomer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        oCustomer.get().setName(customer.getName());
        oCustomer.get().setEmail(customer.getEmail());
        oCustomer.get().setPhone(customer.getPhone());
        oCustomer.get().setActive(customer.getActive());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(oCustomer.get()));
    }
    
    
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        if (!customerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        customerService.deleteById(id);
        
        return ResponseEntity.ok().build();    }
    
}
