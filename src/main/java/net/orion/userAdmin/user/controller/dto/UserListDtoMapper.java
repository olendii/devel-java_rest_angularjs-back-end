package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class UserListDtoMapper {

    public static List<UserListDto> asDto(List<User> users) {
        return new ModelMapper().map(users,  new TypeToken<List<UserListDto>>() {}.getType());
    }

    public static List<User> asEntity(List<UserListDto> userListDtos) {
        return new ModelMapper().map(userListDtos, new TypeToken<List<User>>() {}.getType());
    }

}
