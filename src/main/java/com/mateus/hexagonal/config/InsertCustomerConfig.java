package com.mateus.hexagonal.config;

import com.mateus.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mateus.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mateus.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.mateus.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mateus.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mateus.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.mateus.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase (
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter)
    {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
