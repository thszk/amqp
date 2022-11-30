package com.example.amqp.receiverb.config;

import com.example.amqp.receiverb.domain.constant.ReceiverBConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    public DirectExchange createFanoutExchange() {
        return new DirectExchange(ReceiverBConstant.EXCHANGE_HELLO);
    }

    @Bean
    public Queue createQueue() {
        return new Queue(ReceiverBConstant.QUEUE_HELLO, true);
    }

    @Bean
    public Binding createBinding(DirectExchange directExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(ReceiverBConstant.ROUTING_KEY);
    }

}