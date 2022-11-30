package com.example.amqp.receivera.domain.usecase;

import com.example.amqp.receivera.domain.constant.ReceiverAConstant;
import com.example.amqp.receivera.domain.usecase.exception.MessageConversionException;
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
        if (ReceiverAConstant.RECEIVER_NAME.equals(input.getTo())) {
            log.info("Recebido a mensagem '{}' da queue '{}'", message, ReceiverAConstant.QUEUE_HELLO);
            log.info("Mensagem convertida '{}'", input);
        }
    }

}