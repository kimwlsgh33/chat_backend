package com.cvcvcx.websocketstomp.controller;

import com.cvcvcx.websocketstomp.domain.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/sub/chat/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, ChatMessage message){
        log.info("메세지 전송중.."+message);

        if(ChatMessage.MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender()+"님이 입장하셨습니다.");
        }
        return message;
//        simpMessagingTemplate.convertAndSend("/sub/chat/"+roomId,message);
    }
}
