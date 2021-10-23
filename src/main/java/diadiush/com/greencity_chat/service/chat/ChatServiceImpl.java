package diadiush.com.greencity_chat.service.chat;

import diadiush.com.greencity_chat.dao.chat.ChatDAO;
import diadiush.com.greencity_chat.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatDAO chatDAO;

    @Autowired
    public ChatServiceImpl(ChatDAO chatDAO) {
        this.chatDAO = chatDAO;
    }

    @Override
    @Transactional
    public Chat getChatByID(int chatId) {
        return chatDAO.getChatByID(chatId);
    }

    @Override
    @Transactional
    public List<Chat> getAllUsersChats(int userId) {
        return chatDAO.getAllUsersChats(userId);
    }

    @Override
    @Transactional
    public Chat saveChat(Chat chat) {
        return chatDAO.saveOrUpdateChat(chat);
    }

    @Override
    @Transactional
    public Chat updateChat(Chat chat) {
        Chat existingChat = chatDAO.getChatByID(chat.getId());
        chat.setParticipants(existingChat.getParticipants());
        return chat;
    }

    @Override
    @Transactional
    public void addParticipant(int chatId, int userId) {
        chatDAO.addParticipant(chatId, userId);
    }

    @Override
    @Transactional
    public void deleteChat(int id) {
        chatDAO.deleteChat(id);
    }
}
