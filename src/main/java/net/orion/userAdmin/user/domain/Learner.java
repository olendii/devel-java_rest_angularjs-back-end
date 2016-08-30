package net.orion.userAdmin.user.domain;

import net.orion.userAdmin.reference.domain.Branch;

import java.util.Set;

public class Learner extends User {

    private Branch branch;

    public Learner() {
        this.addRole(RoleEnum.LEARNER);
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
        this.addRole(RoleEnum.LEARNER);
    }

}
