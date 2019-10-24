package com.netcracker.tc.shared.model.user;

import java.io.Serializable;

/**
 * @author unconsionable
 */
public class RoleDTO implements Serializable {

    public static final Long ROLE_USER_ID = 1L;
    public static final Long ROLE_ADMIN_ID = 2L;
    public static final Long ROLE_INTERVIEWER_ID = 3L;
    public static final Long ROLE_HR_ID = 4L;
    public static final Long ROLE_SIMPLE_HR_ID = 5L;

    public static final String ROLE_USER = "1";
    public static final String ROLE_ADMIN = "2";
    public static final String ROLE_INTERVIEWER = "3";
    public static final String ROLE_HR = "4";
    public static final String ROLE_SIMPLE_HR = "5";

    private Long id;
    private String description;

    public RoleDTO(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public RoleDTO() {
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

    public boolean isStudent() {
        return id.equals(ROLE_USER_ID);
    }

    public boolean isAdmin() {
        return id.equals(ROLE_ADMIN_ID);
    }

    public boolean isHR() {
        return id.equals(ROLE_HR_ID);
    }

    public boolean isInterviewer() {
        return id.equals(ROLE_INTERVIEWER_ID);
    }

    public boolean isSimpleHR() {
        return id.equals(ROLE_SIMPLE_HR_ID);
    }
}