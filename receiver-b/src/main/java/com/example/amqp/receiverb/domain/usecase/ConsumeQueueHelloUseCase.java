package com.example.amqp.receiverb.domain.usecase;

import com.example.amqp.receivera.domain.usecase.ConsumeQueueHelloUseCaseInput;
import com.example.amqp.receiverb.domain.constant.ReceiverBConstant;
import com.example.amqp.receiverb.domain.usecase.exception.MessageConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsumeQueueHelloUseCase {

    ObjectMapper objectMapper;

    public void consume(String message) {
        ConsumeQueueHelloUseCaseInput input;
        try {
            input = objectMapper.readValue(message, ConsumeQueueHelloUseCaseInput.class);
        } catch (JsonProcessingException e) {
            throw new MessageConversionException(e);
        }
        if (ReceiverBConstant.RECEIVER_NAME.equals(input.getTo())) {
            log.info("Recebido a mensagem '{}' da queue '{}'", message, ReceiverBConstant.QUEUE_HELLO);
            log.info("Mensagem convertida '{}'", input);
        }
    }

}