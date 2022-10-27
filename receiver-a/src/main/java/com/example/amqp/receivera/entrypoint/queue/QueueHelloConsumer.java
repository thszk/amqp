package com.example.amqp.receivera.entrypoint.queue;

import com.example.amqp.receivera.domain.constant.ReceiverAConstant;
import com.example.amqp.receivera.domain.usecase.ConsumeQueueHelloUseCase;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueueHelloConsumer {

    private ConsumeQueueHelloUseCase consumeQueueHelloUseCase;

    @RabbitListener(queues = {ReceiverAConstant.QUEUE_HELLO})
    public void consumeQueueHello(@Payload String message) {
        consumeQueueHelloUseCase.consume(message);
    }

}