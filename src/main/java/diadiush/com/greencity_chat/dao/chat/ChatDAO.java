package diadiush.com.greencity_chat.dao.chat;

import diadiush.com.greencity_chat.entity.Chat;
import diadiush.com.greencity_chat.entity.User;

import java.util.List;

public interface ChatDAO {

    Chat getChatByID(int chatId);

    List<Chat> getAllUsersChats(int userId);

    Chat saveOrUpdateChat(Chat chat);

    void deleteChat(int id);

    void addParticipant(int chatId, int userId);

    void deleteAllChatMessages(int id);
}
