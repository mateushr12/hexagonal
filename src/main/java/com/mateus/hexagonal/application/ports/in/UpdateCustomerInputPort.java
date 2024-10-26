package com.mateus.hexagonal.application.ports.in;

import com.mateus.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
