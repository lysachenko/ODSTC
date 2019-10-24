package com.netcracker.tc.shared.model.user;

import java.io.Serializable;

public class PositionDTO implements Serializable{

    public static final long QA = 1;
    public static final long DEV = 2;

    private Long id;
    private String description;

    public PositionDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public PositionDTO(String description) {
        this.description = description;
    }

    public PositionDTO() {
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

    public boolean isDev() {
        return id.equals(DEV);
    }
}