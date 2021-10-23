package diadiush.com.greencity_chat.controller;

import diadiush.com.greencity_chat.entity.Message;
import diadiush.com.greencity_chat.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chatId/{chatId}")
    public List<Message> getAllMessagesByChatId(@PathVariable int chatId) {
        return messageService.getAllMessagesByChatId(chatId);
    }

    @GetMapping("/{messageId}")
    public Message findMessageById(@PathVariable int messageId) {
        return messageService.findMessageById(messageId);
    }

    @PostMapping("")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage( message);
    }

    @PutMapping("")
    public Message changeMessage(@RequestBody Message message) {
        return messageService.changeMessage(message);
    }

    @DeleteMapping("/{messageId}")
    public void deleteMessage(@PathVariable int messageId) {
        messageService.deleteMessage(messageId);
    }

}
