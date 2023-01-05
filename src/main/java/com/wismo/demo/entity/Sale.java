/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Miguel
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sale")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Sale implements Serializable{
    
    private static final Long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // para referenciar el JoinColum usado en @OneToOne y solución de problemas
    @Id
    private Long id;
    
    private Float total_sale;
    
    private Date sale_date;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
    
    @Basic
    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items;
}
