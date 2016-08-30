package net.orion.userAdmin.common.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class AbstractEntity<T> {

    protected T id;

    @Autowired
    protected MessageSource messageSourceLabels;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}
