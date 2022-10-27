package com.example.amqp.sender.config;

import com.example.amqp.sender.domain.constant.SenderConstant;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    public FanoutExchange createFanoutExchange() {
        return new FanoutExchange(SenderConstant.EXCHANGE_FANOUT_HELLO);
    }

}