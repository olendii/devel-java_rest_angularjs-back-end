package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.Teacher;
import org.modelmapper.ModelMapper;

public class TeacherFormDtoMapper {

    public static TeacherFormDto asDto(Teacher teacher) {
        if (teacher == null) { return null; }
        else {
            return new ModelMapper().map(teacher, TeacherFormDto.class);
        }
    }

    public static Teacher asEntity(TeacherFormDto teacherFormDto) {
        if (teacherFormDto == null) { return null; }
        else {
            return new ModelMapper().map(teacherFormDto, Teacher.class);
        }
    }

}
