package com.example.amqp.sender.config;

import com.example.amqp.sender.domain.constant.SenderConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    public DirectExchange createDirectExchange() {
        return new DirectExchange(SenderConstant.EXCHANGE_HELLO);
    }

}