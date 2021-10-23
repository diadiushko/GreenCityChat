package diadiush.com.greencity_chat.service.user;

import diadiush.com.greencity_chat.entity.User;

public interface UserService {
    User getUserById(int id);

    User saveOrUpdateUser(User user);

    void deleteUser(int id);
}
