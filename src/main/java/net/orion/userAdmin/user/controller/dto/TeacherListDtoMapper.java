package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.Teacher;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;

import java.util.List;

public class TeacherListDtoMapper {

    public static List<TeacherListDto> asDto(List<Teacher> teachers) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Teacher.class, TeacherListDto.class);
        modelMapper.addMappings(new PropertyMap<Teacher, TeacherListDto>() {
            @Override
            protected void configure() {
                map().setBranchName(source.getBranch().getName());
            }
        });
        return modelMapper.map(teachers,  new TypeToken<List<TeacherListDto>>() {}.getType());
    }

    public static List<Teacher> asEntity(List<TeacherListDto> teacherListDtos) {
        return new ModelMapper().map(teacherListDtos, new TypeToken<List<Teacher>>() {}.getType());
    }

}
