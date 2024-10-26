package com.mateus.hexagonal.config;

import com.mateus.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mateus.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mateus.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mateus.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mateus.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.mateus.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase (
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase)
    {
        return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, updateCustomerAdapter, findCustomerByIdUseCase);
    }
}
