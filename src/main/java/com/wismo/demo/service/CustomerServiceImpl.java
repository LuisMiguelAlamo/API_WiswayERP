/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import com.wismo.demo.entity.Customer;
import com.wismo.demo.repository.CustomerRepository;
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
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    @Transactional
    public Customer update(Long id, Customer customer) {
//        Optional<Customer> newCustomer = customerRepo.findById(id);
        return customerRepo.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Long contar() {
        return customerRepo.count();
    }
    
}
