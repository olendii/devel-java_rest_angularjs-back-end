package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.common.dao.AbstractDao;
import net.orion.userAdmin.user.domain.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao implements TeacherDao {

    public void saveTeacher(Teacher teacher) {
        persist(teacher);
    }

    @SuppressWarnings("unchecked")
    public List<Teacher> findAllTeachers() {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        return (List<Teacher>) criteria.list();
    }

    public void deleteTeacherById(long id) {
        Query query = getSession().createSQLQuery("delete from users where user_id = :teacher_id");
        query.setLong("teacher_id", id);
        query.executeUpdate();
    }

    public Teacher findTeacherById(long id) {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add(Restrictions.eq("id", id));
        return (Teacher) criteria.uniqueResult();
    }

    public void updateTeacher(Teacher teacher) {
        getSession().update(teacher);
    }

    public Teacher findTeacherByLogin(String login) {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add(Restrictions.eq("login", login));
        return (Teacher) criteria.uniqueResult();
    }

}
