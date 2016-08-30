package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.User;
import org.modelmapper.ModelMapper;

public class UserFormDtoMapper {

    public static UserFormDto asDto(User user) {
        if (user == null) { return null; }
        else {
//            ModelMapper modelMapper = new ModelMapper();
//            modelMapper.createTypeMap(User.class, UserFormDto.class);
//            modelMapper.addMappings(new PropertyMap<User, UserFormDto>() {
//                @Override
//                protected void configure() {
//                    map().setRoles(source.getRolesAsStrings());
//                }
//            });
//            return modelMapper.map(user, UserFormDto.class);
            return new ModelMapper().map(user, UserFormDto.class);
        }
    }

    public static User asEntity(UserFormDto userFormDto) {
        if (userFormDto == null) { return null; }
        else {
//            ModelMapper modelMapper = new ModelMapper();
//            modelMapper.createTypeMap(UserFormDto.class, User.class);
//            modelMapper.addMappings(new PropertyMap<UserFormDto, User>() {
//                @Override
//                protected void configure() {
//                    map().setRolesAsStrings(source.getRoles());
//                }
//            });
//            return modelMapper.map(userFormDto, User.class);
            return new ModelMapper().map(userFormDto, User.class);
        }
    }

}
