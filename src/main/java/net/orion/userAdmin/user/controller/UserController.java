package net.orion.userAdmin.user.controller;

import net.orion.userAdmin.user.controller.dto.UserFormDtoMapper;
import net.orion.userAdmin.user.controller.dto.UserListDtoMapper;
import net.orion.userAdmin.user.domain.User;
import net.orion.userAdmin.user.service.UserService;
import net.orion.userAdmin.user.controller.dto.UserFormDto;
import net.orion.userAdmin.user.controller.dto.UserListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Retrieve all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserListDto>> listAllUsers() {
        List<UserListDto> userListDtos = UserListDtoMapper.asDto(userService.findAllUsers());
        if(userListDtos.isEmpty()){
            return new ResponseEntity<List<UserListDto>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserListDto>>(userListDtos, HttpStatus.OK);
    }

    // Retrieve single user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserFormDto> getUser(@PathVariable("id") long id) {
        UserFormDto userFormDto = UserFormDtoMapper.asDto(userService.findUserById(id));
        if (userFormDto == null) {
            return new ResponseEntity<UserFormDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserFormDto>(userFormDto, HttpStatus.OK);
    }

    // Create a user
    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserFormDto userFormDto, UriComponentsBuilder ucBuilder) {

        User newUser = UserFormDtoMapper.asEntity(userFormDto);
        if (userService.isUserExist(newUser)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.saveUser(newUser);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserFormDto> updateUser(@PathVariable("id") long id, @RequestBody UserFormDto userFormDto) {

        UserFormDto currentUser = UserFormDtoMapper.asDto(userService.findUserById(id));

        if (currentUser == null) {
            return new ResponseEntity<UserFormDto>(HttpStatus.NOT_FOUND);
        }

        userService.updateUser(UserFormDtoMapper.asEntity(userFormDto));
        return new ResponseEntity<UserFormDto>(userFormDto, HttpStatus.OK);
    }

    // Delete a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserFormDto> deleteUser(@PathVariable("id") long id) {

        User user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<UserFormDto>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<UserFormDto>(HttpStatus.NO_CONTENT);
    }

}
