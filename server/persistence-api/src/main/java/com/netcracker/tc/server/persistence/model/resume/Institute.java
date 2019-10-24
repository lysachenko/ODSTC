package com.netcracker.tc.server.persistence.model.resume;

import java.io.Serializable;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class Institute implements Serializable {

    private static final Long OTHER_INSTITUTE_ID = 8L;

    private Long id;
    private String description;

    public Institute(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Institute() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOther(){
        return id.equals(OTHER_INSTITUTE_ID);
    }
}