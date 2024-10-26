package com.mateus.hexagonal.config;

import com.mateus.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.mateus.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mateus.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mateus.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.mateus.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mateus.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase (
            DeleteCustomerAdapter deleteCustomerAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase)
    {
        return new DeleteCustomerUseCase(deleteCustomerAdapter, findCustomerByIdUseCase);
    }
}
