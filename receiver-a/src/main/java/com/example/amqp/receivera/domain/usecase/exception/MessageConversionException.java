package com.example.amqp.receivera.domain.usecase.exception;

public class MessageConversionException extends RuntimeException {
    public MessageConversionException(Throwable e) {
        super("Failed to convert JSON message data to object", e);
    }
}