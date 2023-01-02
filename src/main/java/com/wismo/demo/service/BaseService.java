/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Luis Miguel
 * @param <E>
 * @param <ID>
 */
public interface BaseService <E, ID extends Serializable>{
    
    public List<E> findAll();
    
     public Page<E> findAll(Pageable pageable);
    
    public Optional<E> findById(ID id);
    
    public E save(@Valid E entity);
    
    public E update(ID id, @Valid E entity);
    
    public void deleteById(ID id);
    
    public Long contar();
    
}
