package com.mateus.hexagonal.application.core.usecase;

import com.mateus.hexagonal.application.core.domain.Address;
import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mateus.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mateus.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.mateus.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mateus.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.mateus.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mateus.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    // Imutabilidade: Use final em atributos de classe para garantir que o valor do atributo não seja alterado após a construção do objeto.
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public UpdateCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
