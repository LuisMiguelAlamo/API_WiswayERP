/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Vendor;
import com.wismo.demo.repository.VendorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Miguel
 */
@Service
public class VendorServiceImpl implements VendorService{
    
    @Autowired
    private VendorRepository vendorRepo;

    @Override
    public List<Vendor> findAll() {
        return vendorRepo.findAll();
    }

    @Override
    public Page<Vendor> findAll(Pageable pageable) {
        return vendorRepo.findAll(pageable);
    }

    @Override
    public Optional<Vendor> findById(Long id) {
        return vendorRepo.findById(id);
    }

    @Override
    public Vendor save(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    @Override
    public Vendor update(Long id, Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    @Override
    public void deleteById(Long id) {
        vendorRepo.deleteById(id);
    }

    @Override
    public Long contar() {
        return vendorRepo.count();
    }
    
    
}
