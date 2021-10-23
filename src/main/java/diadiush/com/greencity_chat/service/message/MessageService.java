package diadiush.com.greencity_chat.service.message;

import diadiush.com.greencity_chat.entity.Message;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageService {
    List<Message> getAllMessagesByChatId(int chatId);

    Message findMessageById(int id);

    Message changeMessage(Message message);

    Message addMessage(Message message);

    void deleteMessage(int msgId);
}