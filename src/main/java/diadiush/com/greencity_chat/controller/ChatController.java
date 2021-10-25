package diadiush.com.greencity_chat.controller;

import diadiush.com.greencity_chat.entity.Chat;
import diadiush.com.greencity_chat.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/{chatId}")
    public Chat getChatById(@PathVariable int chatId) {
        return chatService.getChatByID(chatId);
    }

    @GetMapping("/userId/{userId}")
    public List<Chat> getAllUserChatsById(@PathVariable int userId) {
        return chatService.getAllUsersChats(userId);
    }

    @PostMapping("")
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.saveChat(chat);
    }

    @PutMapping("/{chatId}/participant/{userId}")
    public void addParticipant(@PathVariable int chatId, @PathVariable int userId) {
        chatService.addParticipant(chatId, userId);
    }

    @MessageMapping("/sos")
    @SendTo("/message/hello")
    public String func(String input) {
        System.out.println(input);
        return input;
    }

    @PutMapping("")
    public Chat updateChat(@RequestBody Chat chat) {
        return chatService.updateChat(chat);
    }

    @DeleteMapping("/{chatId}")
    public void deleteChat(@PathVariable int chatId) {
        chatService.deleteChat(chatId);
    }
}
