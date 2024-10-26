package com.mateus.hexagonal.application.ports.out;

import com.mateus.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
