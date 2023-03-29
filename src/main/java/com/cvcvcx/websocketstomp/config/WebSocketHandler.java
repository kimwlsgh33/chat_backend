//package com.cvcvcx.websocketstomp.config;
//
//import com.cvcvcx.websocketstomp.domain.dto.ChatMessage;
//import com.cvcvcx.websocketstomp.domain.dto.ChatRoom;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@RequiredArgsConstructor
//@Slf4j
//@Component
//public class WebSocketHandler extends TextWebSocketHandler {
//
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
//        //원래는 접속하면 Welcome Chatting 하고 본문을 보여주는 식이었다.
//        //결국은 session에 있는 sendMessage 로 여기 연결되어있는 구독자 전원에게
////        TextMessage textMessage = new TextMessage("Welcome chatting "+payload);
////        session.sendMessage(textMessage);
//        // session 에 들어온 메세지를 읽어서, ChatMessage 형태로 변경한다.
//        ChatMessage chatMessage = objectMapper.readValue(payload,ChatMessage.class);
//        // chatMessage 에 써져있는 아이디로 전송할 room을 파악한다.
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        //그 룸의 handleAction 을 통해 chatMessage를 처리한다.
//        room.handleActions(session,chatMessage,chatService);
//    }
//}
