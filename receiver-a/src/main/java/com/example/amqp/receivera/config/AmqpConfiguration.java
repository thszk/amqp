package com.example.amqp.receivera.config;

import com.example.amqp.receivera.domain.constant.ReceiverAConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    public FanoutExchange createFanoutExchange() {
        return new FanoutExchange(ReceiverAConstant.EXCHANGE_FANOUT_HELLO);
    }

    @Bean
    public Queue createQueue() {
        return new Queue(ReceiverAConstant.QUEUE_HELLO, true);
    }

    @Bean
    public Binding createBinding(FanoutExchange fanoutExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}