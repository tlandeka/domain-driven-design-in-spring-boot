package com.example.excercise.infrastructure.springboot.config;

import com.example.excercise.application.payment.*;
import com.example.excercise.infrastructure.persistence.jpa.payment.AccountJPARepository;
import com.example.excercise.infrastructure.persistence.jpa.payment.PaymentJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfiguredBeans {

    // Auto-configured beans

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}