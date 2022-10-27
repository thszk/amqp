package com.example.amqp.sender.entrypoint.controller.message;

import com.example.amqp.sender.domain.usecase.SendMessageUseCase;
import com.example.amqp.sender.domain.usecase.SendMessageUseCaseInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private SendMessageUseCase sendMessageUseCase;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody SendMessageUseCaseInput input) {
        sendMessageUseCase.send(input);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}