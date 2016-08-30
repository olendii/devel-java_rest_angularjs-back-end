package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.common.dao.AbstractDao;
import net.orion.userAdmin.user.domain.Learner;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("learnerDao")
public class LearnerDaoImpl extends AbstractDao implements LearnerDao {

    public void saveLearner(Learner learner) {
        persist(learner);
    }

    @SuppressWarnings("unchecked")
    public List<Learner> findAllLearners() {
        Criteria criteria = getSession().createCriteria(Learner.class);
        return (List<Learner>) criteria.list();
    }

    public void deleteLearnerById(long id) {
        Query query = getSession().createSQLQuery("delete from users where user_id = :learner_id");
        query.setLong("learner_id", id);
        query.executeUpdate();
    }

    public Learner findLearnerById(long id) {
        Criteria criteria = getSession().createCriteria(Learner.class);
        criteria.add(Restrictions.eq("id", id));
        return (Learner) criteria.uniqueResult();
    }

    public void updateLearner(Learner learner) {
        getSession().update(learner);
    }

    public Learner findLearnerByLogin(String login) {
        Criteria criteria = getSession().createCriteria(Learner.class);
        criteria.add(Restrictions.eq("login", login));
        return (Learner) criteria.uniqueResult();
    }

}
