package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.user.domain.Teacher;

import java.util.List;

public interface TeacherDao {

    void saveTeacher(Teacher teacher);

    List<Teacher> findAllTeachers();

    void deleteTeacherById(long id);

    Teacher findTeacherById(long id);

    void updateTeacher(Teacher teacher);

    Teacher findTeacherByLogin(String login);

}
