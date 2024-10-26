package com.mateus.hexagonal.adapters.in.controller.mapper;

import com.mateus.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mateus.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {

    CustomerResponse toCustomerResponse(Customer customer);
}
