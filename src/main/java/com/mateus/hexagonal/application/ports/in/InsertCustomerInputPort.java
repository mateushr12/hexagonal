package com.mateus.hexagonal.application.ports.in;

import com.mateus.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
