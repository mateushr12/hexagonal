package com.mateus.hexagonal.application.core.usecase;

import com.mateus.hexagonal.application.core.domain.Address;
import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mateus.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mateus.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mateus.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    // Imutabilidade: Use final em atributos de classe para garantir que o valor do atributo não seja alterado após a construção do objeto.
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
