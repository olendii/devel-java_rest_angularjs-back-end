package net.orion.userAdmin.user.domain;

import net.orion.userAdmin.common.domain.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

public class User extends AbstractEntity<Long> {

    private String name;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String note;
    private Boolean isEnabled;
    private Set<RoleEnum> roles = new HashSet<RoleEnum>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    public Set<String> getRolesAsStrings() {
        Set<String> result = new HashSet<String>();
        for(RoleEnum roleEnum: roles ) {
            result.add(roleEnum.toString());
        }
        return result;
    }

    public void setRolesAsStrings(Set<String> rolesFromStrings) {
        roles.clear();
        for(String roleString: rolesFromStrings) {
            roles.add(RoleEnum.valueOf(roleString));
        }
    }

    public void addRole(RoleEnum role) {
        roles.add(role);
    }

}
