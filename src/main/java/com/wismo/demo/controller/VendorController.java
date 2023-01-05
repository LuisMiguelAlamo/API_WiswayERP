/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.controller;

import com.wismo.demo.entity.Vendor;
import com.wismo.demo.service.VendorService;
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
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody Vendor vendor) {
        try {

            return ResponseEntity.ok().body(vendorService.save(vendor));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    private ResponseEntity<?> readAll() {
        try {
            List<Vendor> vendors = (List) vendorService.findAll();

            return ResponseEntity.ok().body(vendors);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> readOne(@PathVariable Long id) {
        try {
            Optional<Vendor> oVendor = vendorService.findById(id);

            if (!oVendor.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(oVendor);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Vendor newVendor) {
        try {
            Optional<Vendor> oVendor = vendorService.findById(id);
            
            if (!oVendor.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            oVendor.get().setName(newVendor.getName());
            oVendor.get().setAddress(newVendor.getAddress());
            oVendor.get().setPhone(newVendor.getPhone());

            return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(oVendor.get()));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Optional<Vendor> oVendor = vendorService.findById(id);
            
            if (!oVendor.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            
            vendorService.deleteById(id);

            return ResponseEntity.ok().body(oVendor);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
