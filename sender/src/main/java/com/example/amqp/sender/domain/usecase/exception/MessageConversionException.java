package com.example.amqp.sender.domain.usecase.exception;

public class MessageConversionException extends RuntimeException {
    public MessageConversionException(Throwable e) {
        super("Failed to convert message data to JSON", e);
    }
}