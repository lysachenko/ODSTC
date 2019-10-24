package com.netcracker.tc.server.persistence.model.user;

public class UserPagingFilter {

    private Long roleId;
    private String name;
    private String email;
    private String telephone;
    private Boolean hrResultInterview;
    private Boolean devResultInterview;
    private Long positionId;
    private Long usedStatusId;

    public UserPagingFilter(){
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getHrResultInterview() {
        return hrResultInterview;
    }

    public void setHrResultInterview(Boolean hrResultInterview) {
        this.hrResultInterview = hrResultInterview;
    }

    public Boolean getDevResultInterview() {
        return devResultInterview;
    }

    public void setDevResultInterview(Boolean devResultInterview) {
        this.devResultInterview = devResultInterview;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getUsedStatusId() {
        return usedStatusId;
    }

    public void setUsedStatusId(Long usedStatusId) {
        this.usedStatusId = usedStatusId;
    }
}