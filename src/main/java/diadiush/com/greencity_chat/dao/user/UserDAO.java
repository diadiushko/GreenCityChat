package diadiush.com.greencity_chat.dao.user;

import diadiush.com.greencity_chat.entity.User;

public interface UserDAO {
    User getUserById(int id);

    User saveOrUpdateUser(User user);

    void delete(int id);
}
