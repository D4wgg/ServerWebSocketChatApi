package ru.stupor.chatapplication.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.stupor.chatapplication.model.InputMessage;
import ru.stupor.chatapplication.model.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/app/chat")
    @SendTo("/topic/messages")
    public OutputMessage sendMessage(@Payload InputMessage message) {
        System.out.println(String.format("%s: %s", message.from(), message.text()));
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.from(), message.text(), time);
    }

}
