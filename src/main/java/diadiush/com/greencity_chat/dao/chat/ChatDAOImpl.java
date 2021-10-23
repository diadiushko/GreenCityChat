package diadiush.com.greencity_chat.dao.chat;

import diadiush.com.greencity_chat.entity.Chat;
import diadiush.com.greencity_chat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ChatDAOImpl implements ChatDAO{

    private final EntityManager entityManager;

    @Autowired
    public ChatDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Chat getChatByID(int chatId) {
        return entityManager.find(Chat.class, chatId);
    }

    @Override
    public List<Chat> getAllUsersChats(int userId) {
        Query allChatsByIdQuery = entityManager.createQuery("SELECT c FROM Chat c INNER JOIN c.participants p ON p.id=:userId", Chat.class);
        allChatsByIdQuery.setParameter("userId", userId);
        return allChatsByIdQuery.getResultList();
    }

    @Override
    public Chat saveOrUpdateChat(Chat chat) {
        return entityManager.merge(chat);
    }

    @Override
    public void addParticipant(int chatId, int userId) {
        Chat chatToAddParticipants = entityManager.find(Chat.class, chatId);
        User userToAdd = entityManager.find(User.class, userId);
        chatToAddParticipants.getParticipants().add(userToAdd);
    }

    @Override
    public void deleteChat(int id) {
        Query deleteChatByIdQuery = entityManager.createQuery("DELETE Chat WHERE id=:id");
        deleteChatByIdQuery.setParameter("id", id);
        deleteChatByIdQuery.executeUpdate();
    }
}
