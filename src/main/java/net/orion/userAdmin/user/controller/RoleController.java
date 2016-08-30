package net.orion.userAdmin.user.controller;

import net.orion.userAdmin.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Retrieve all roles
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseEntity<Set<String>> listAllRoles() {
        Set<String> roles = roleService.findAllRoles();
        if(roles.isEmpty()){
            return new ResponseEntity<Set<String>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<String>>(roles, HttpStatus.OK);
    }

}
