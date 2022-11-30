package com.example.amqp.receiverb.entrypoint.queue;

import com.example.amqp.receiverb.domain.constant.ReceiverBConstant;
import com.example.amqp.receiverb.domain.usecase.ConsumeQueueHelloUseCase;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueueHelloConsumer {

    private ConsumeQueueHelloUseCase consumeQueueHelloUseCase;

    @RabbitListener(queues = {ReceiverBConstant.QUEUE_HELLO})
    public void consumeQueueHello(@Payload String message) {
        consumeQueueHelloUseCase.consume(message);
    }

}