package net.orion.userAdmin.user.domain;

import net.orion.userAdmin.reference.domain.Branch;

import java.util.Set;

public class Teacher extends User {

    private Branch branch;

    public Teacher() {
        this.addRole(RoleEnum.TEACHER);
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public void setRoles(Set<RoleEnum> roles) {
        super.setRoles(roles);
        this.addRole(RoleEnum.TEACHER);
    }

}
