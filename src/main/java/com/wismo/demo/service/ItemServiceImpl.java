/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Item;
import com.wismo.demo.repository.ItemRepository;
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
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemRepository itemRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Item> findAll(Pageable pageable) {
        return itemRepo.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepo.save(item);
    }

    @Override
    @Transactional
    public Item update(Long id, Item item) {
        return itemRepo.save(item);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        itemRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Long contar() {
        return itemRepo.count();
    }
    
}
