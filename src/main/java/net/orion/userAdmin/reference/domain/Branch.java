package net.orion.userAdmin.reference.domain;

import net.orion.userAdmin.common.domain.AbstractEntity;

public class Branch extends AbstractEntity<Short> {

    private String name;
    private Boolean isEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

}
