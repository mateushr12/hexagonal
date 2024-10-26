package com.mateus.hexagonal.adapters.in.consumer;

import com.mateus.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.mateus.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RecieveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    // servicos diferente - sao consumer diferente e tem groupid diferentes
    @KafkaListener(topics = "tp-cpf-validated", groupId = "mateus")
    public void receive(CustomerMessage customerMessage){
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
