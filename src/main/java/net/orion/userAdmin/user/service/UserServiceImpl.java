package net.orion.userAdmin.user.service;

import net.orion.userAdmin.user.dao.UserDao;
import net.orion.userAdmin.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public void deleteUserById(long id) {
        dao.deleteUserById(id);
    }

    public User findUserById(long id) {
        return dao.findUserById(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public User findUserByLogin(String login) { return dao.findUserByLogin(login); }

    public boolean isUserExist(User user) {
        return findUserByLogin(user.getLogin()) != null;
    }

}
