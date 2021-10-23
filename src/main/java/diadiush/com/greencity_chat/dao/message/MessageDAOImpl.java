package diadiush.com.greencity_chat.dao.message;

import diadiush.com.greencity_chat.entity.Chat;
import diadiush.com.greencity_chat.entity.Message;
import diadiush.com.greencity_chat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO{

    private final EntityManager entityManager;

    @Autowired
    public MessageDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Message> getAllMessagesByChatId(int chatId) {
        Query allMessagesByChatIdQuery = entityManager.createQuery("FROM Message WHERE chat=:chatId");
        allMessagesByChatIdQuery.setParameter("chatId", chatId);
        return allMessagesByChatIdQuery.getResultList();
    }

    @Override
    public Message findMessageById(int id) {
        return entityManager.find(Message.class, id);
    }

    @Override
    public Message changeMessage(Message message) {
        return entityManager.merge(message);
    }

    @Override
    public Message addMessage(Message message) {
        return entityManager.merge(message);
    }

    @Override
    public void deleteMessage(int msgId) {
        Query deleteCertainMessageQuery = entityManager.createQuery("DELETE Message WHERE id=:msgId");
        deleteCertainMessageQuery.setParameter("msgId", msgId);
        deleteCertainMessageQuery.executeUpdate();
    }
}
