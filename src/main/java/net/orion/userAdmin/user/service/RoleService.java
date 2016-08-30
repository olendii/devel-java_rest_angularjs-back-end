package net.orion.userAdmin.user.service;

import net.orion.userAdmin.user.domain.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("roleService")
public class RoleService {
    
    public Set<String> findAllRoles() {
        HashSet<String> roles = new HashSet<String>();
        for(RoleEnum role: RoleEnum.values()) {
            roles.add(role.toString());
        }
        return roles;
    }
    
}
