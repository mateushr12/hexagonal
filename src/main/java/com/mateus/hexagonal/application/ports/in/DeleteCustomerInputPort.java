package com.mateus.hexagonal.application.ports.in;

import com.mateus.hexagonal.application.core.domain.Customer;

public interface DeleteCustomerInputPort {

    void delete(String id);
}
