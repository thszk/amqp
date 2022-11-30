package com.example.amqp.sender.domain.usecase;

import com.example.amqp.sender.domain.constant.SenderConstant;
import com.example.amqp.sender.domain.usecase.exception.MessageConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SendMessageUseCase {

    private ObjectMapper objectMapper;
    private RabbitTemplate rabbitTemplate;

    public void send(SendMessageUseCaseInput input) {
        String message;
        try {
            message = objectMapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new MessageConversionException(e);
        }
        rabbitTemplate.convertAndSend(SenderConstant.EXCHANGE_HELLO, input.getTo(), message);
        log.info("Enviado a mensagem '{}' para o exchange '{}'", message, SenderConstant.EXCHANGE_HELLO);
    }

}