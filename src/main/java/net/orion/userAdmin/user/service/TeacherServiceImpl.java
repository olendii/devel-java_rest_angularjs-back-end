package net.orion.userAdmin.user.service;

import net.orion.userAdmin.user.dao.TeacherDao;
import net.orion.userAdmin.user.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao dao;

    public void saveTeacher(Teacher teacher) {
        dao.saveTeacher(teacher);
    }

    public List<Teacher> findAllTeachers() {
        return dao.findAllTeachers();
    }

    public void deleteTeacherById(long id) {
        dao.deleteTeacherById(id);
    }

    public Teacher findTeacherById(long id) {
        return dao.findTeacherById(id);
    }

    public void updateTeacher(Teacher teacher) {
        dao.updateTeacher(teacher);
    }

    public Teacher findTeacherByLogin(String login) {
        return dao.findTeacherByLogin(login);
    }

    public boolean isTeacherExist(Teacher teacher) {
        return findTeacherByLogin(teacher.getLogin()) != null;
    }

}
