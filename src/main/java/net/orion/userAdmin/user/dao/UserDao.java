package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.user.domain.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserById(long id);

    User findUserById(long id);

    void updateUser(User user);

    User findUserByLogin(String login);

}
