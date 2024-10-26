package com.mateus.hexagonal.adapters.out;

import com.mateus.hexagonal.adapters.out.repository.CustomerRepository;
import com.mateus.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mateus.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id){
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(x -> customerEntityMapper.toCustomer(x));
    }
}
