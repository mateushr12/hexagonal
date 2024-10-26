package com.mateus.hexagonal.application.ports.out;

import com.mateus.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
