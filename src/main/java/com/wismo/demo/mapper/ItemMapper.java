/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wismo.demo.mapper;

import com.wismo.demo.dto.CustomerDto;
import com.wismo.demo.dto.ItemDto;
import com.wismo.demo.entity.Customer;
import com.wismo.demo.entity.Item;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 *
 * @author Luis Miguel
 */
@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toEntity(ItemDto itemDto);

    ItemDto toDto(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CustomerDto customerDto, @MappingTarget Customer customer);
}

