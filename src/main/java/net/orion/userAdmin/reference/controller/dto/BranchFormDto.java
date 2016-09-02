package net.orion.userAdmin.reference.controller.dto;

public class BranchFormDto {

    private Short id;
    private String name;
    private Boolean isEnabled;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

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
