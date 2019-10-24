package com.netcracker.tc.shared.model.resume;

import java.io.Serializable;

public class ResumeStatusDTO implements Serializable{

    private Long id;
    private String description;

    public ResumeStatusDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ResumeStatusDTO() {
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
}