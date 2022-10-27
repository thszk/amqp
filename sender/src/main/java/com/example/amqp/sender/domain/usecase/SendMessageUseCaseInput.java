package com.example.amqp.sender.domain.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageUseCaseInput implements Serializable {
    private String from;
    private String to;
    private String message;
}