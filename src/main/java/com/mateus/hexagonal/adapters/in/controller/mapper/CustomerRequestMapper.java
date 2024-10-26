package com.mateus.hexagonal.adapters.in.controller.mapper;

import com.mateus.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mateus.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "string")
public interface CustomerRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
