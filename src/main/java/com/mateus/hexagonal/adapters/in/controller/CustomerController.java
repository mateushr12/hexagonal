package com.mateus.hexagonal.adapters.in.controller;

import com.mateus.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.mateus.hexagonal.adapters.in.controller.mapper.CustomerResponseMapper;
import com.mateus.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mateus.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.mateus.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mateus.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mateus.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerRequestMapper customerRequestMapper;

    @Autowired
    private CustomerResponseMapper customerResponseMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        Customer customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok().body(customerResponseMapper.toCustomerResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerRequestMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        Customer customer = findCustomerByIdInputPort.find(id);
        deleteCustomerInputPort.delete(customer.getId());
        return ResponseEntity.ok().build();
    }


}
