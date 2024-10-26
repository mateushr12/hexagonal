package com.mateus.hexagonal.application.ports.in;

import com.mateus.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
