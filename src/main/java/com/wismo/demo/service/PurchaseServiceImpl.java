/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Purchase;
import com.wismo.demo.repository.PurchaseRepository;
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
public class PurchaseServiceImpl implements PurchaseService{
    
    @Autowired
    private PurchaseRepository purchaseRepo;

    @Override
    public List<Purchase> findAll() {
        return purchaseRepo.findAll();
    }

    @Override
    public Page<Purchase> findAll(Pageable pageable) {
        return purchaseRepo.findAll(pageable);
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return purchaseRepo.findById(id);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepo.save(purchase);
    }

    @Override
    public Purchase update(Long id, Purchase purchase) {
        return purchaseRepo.save(purchase);
    }

    @Override
    public void deleteById(Long id) {
        purchaseRepo.deleteById(id);
    }

    @Override
    public Long contar() {
        return purchaseRepo.count();
    }
    
}
