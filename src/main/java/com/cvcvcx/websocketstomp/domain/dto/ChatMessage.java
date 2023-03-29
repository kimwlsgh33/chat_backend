package com.cvcvcx.websocketstomp.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatMessage {

    public enum MessageType{
        ENTER,TALK
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

}
