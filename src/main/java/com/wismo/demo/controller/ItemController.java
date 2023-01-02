/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Item;
import com.wismo.demo.service.ItemService;
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
@RequestMapping("/api/item")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @PostMapping
    private ResponseEntity<?> create(@RequestBody Item item){
        try {            
            return ResponseEntity.ok().body(itemService.save(item));
            
        } catch (Exception  e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    private ResponseEntity<?> readAll(){
        List<Item> items = (List)itemService.findAll();
        items.size();
        
        return ResponseEntity.ok().body(items);
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<?> readOne(@PathVariable Long id){
        Optional<Item> oItem = itemService.findById(id);
        
        if (!oItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok().body(oItem);
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Item newItem){
        Optional<Item> oItem = itemService.findById(id);
        
        if (!oItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        oItem.get().setName(newItem.getName());
        oItem.get().setPrice(newItem.getPrice());
        oItem.get().setActive(newItem.getActive());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(oItem.get()));
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        if (!itemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        itemService.deleteById(id);
        
        return ResponseEntity.ok().build();   
    }
}