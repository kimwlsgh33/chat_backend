package com.cvcvcx.websocketstomp.controller;

import com.cvcvcx.websocketstomp.domain.dto.ChatRoom;
import com.cvcvcx.websocketstomp.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;


    @PostMapping
    public ChatRoom createRoom(@RequestBody ChatRoom chatRoom){
        return chatRoomRepository.createChatRoom(chatRoom.getName());
    }

    @GetMapping
    public List<ChatRoom> findAllRoom(){
        return chatRoomRepository.findAllRoom();
    }


}
