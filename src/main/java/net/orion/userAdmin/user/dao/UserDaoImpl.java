package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.common.dao.AbstractDao;
import net.orion.userAdmin.user.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    public void saveUser(User user) {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    public void deleteUserById(long id) {
        Query query = getSession().createSQLQuery("delete from users where user_id = :user_id");
        query.setLong("user_id", id);
        query.executeUpdate();
    }

    public User findUserById(long id) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }

    public void updateUser(User user) {
        getSession().update(user);
    }

    public User findUserByLogin(String login) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

}
