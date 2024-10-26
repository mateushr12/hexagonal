package com.mateus.hexagonal.config;

import com.mateus.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mateus.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mateus.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mateus.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mateus.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase (
            FindCustomerByIdAdapter findCustomerByIdAdapter)
    {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
