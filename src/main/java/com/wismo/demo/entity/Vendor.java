/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wismo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "vendor")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Vendor implements Serializable{
    
    private static final Long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // para referenciar el JoinColum usado en @OneToOne y solución de problemas
    @Id
    private Long id;
    
    @Column()
    private String name;
    
    @Column()
    private String address;
    
    @Column()
    private String phone;
}
