package com.mateus.hexagonal.adapters.out.client.mapper;

import com.mateus.hexagonal.adapters.out.client.response.AddressResponse;
import com.mateus.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
