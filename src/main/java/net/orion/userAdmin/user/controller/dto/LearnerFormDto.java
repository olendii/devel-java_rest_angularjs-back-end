package net.orion.userAdmin.user.controller.dto;

import java.util.HashSet;
import java.util.Set;

public class LearnerFormDto {

    private Long id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String note;
    private Boolean isEnabled;
    private Set<String> roles = new HashSet<String>();
    private short branchId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public short getBranchId() {
        return branchId;
    }

    public void setBranchId(short branchId) {
        this.branchId = branchId;
    }

}
