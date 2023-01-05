/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Item;
import com.wismo.demo.entity.Sale;
import com.wismo.demo.repository.ItemRepository;
import com.wismo.demo.repository.SaleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis Miguel
 */
@Service
public class SaleServiceImpl implements SaleService{
    
    @Autowired
    private SaleRepository saleRepo;
    
    @Autowired
    private ItemRepository itemRepo;

    @Override
//    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        List<Sale> saleAux = saleRepo.findAll();
        saleAux.size();
        return saleAux;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sale> findAll(Pageable pageable) {
        return saleRepo.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sale> findById(Long id) {
        return saleRepo.findById(id);
    }

    @Override
    @Transactional
    public Sale save(Sale sale) {
        return saleRepo.save(sale);
    }

    @Override
    @Transactional
    public Sale update(Long id, Sale sale) {
        return saleRepo.save(sale);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        saleRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Long contar() {
        return saleRepo.count();
    }

    @Override
    @Transactional
    public Item getItem(Long id){
        Optional<Item> item = itemRepo.findById(id);
        
        return item.get();
    }
    
//    @Override
//    @Transactional
//    public Item removeItem(Long id){
//        Optional<Item> item = itemRepo.findById(id);
//        
//        return item.get();
//    }
    
}    

