package com.mateus.hexagonal.application.core.usecase;

import com.mateus.hexagonal.application.core.domain.Customer;
import com.mateus.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.mateus.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mateus.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import com.mateus.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort){
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdInputPort =findCustomerByIdInputPort;
    }

    @Override
    public void delete(String id){
         findCustomerByIdInputPort.find(id);
         deleteCustomerOutputPort.delete(id);
    }
}
