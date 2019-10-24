package com.netcracker.tc.shared.model.resume;

import java.io.Serializable;

/**
 * Created by unconsionable on 05.08.2014.
 */
public class InstituteDTO implements Serializable{

    public static final Long OTHER_INSTITUTE_ID = Long.valueOf(8L);

    private Long id;
    private String description;

    public InstituteDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public InstituteDTO() {
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

    public boolean isOtherInstitute() {
        return id.equals(OTHER_INSTITUTE_ID);
    }
}
