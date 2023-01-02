/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
//import java.util.List;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "purchase")
@SuppressWarnings("PersistenceUnitPresent")
public class Purchase implements Serializable{
    
    private static final Long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // para referenciar el JoinColum usado en @OneToOne y solución de problemas
    @Id
    private Long id;
    
    private Float purchase_total;
    
    private Date purhcase_date;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Vendor vendor;
    
}
