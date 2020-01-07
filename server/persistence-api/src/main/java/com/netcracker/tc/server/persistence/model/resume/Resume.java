package com.netcracker.tc.server.persistence.model.resume;

import com.netcracker.tc.server.persistence.model.user.User;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Resume implements Serializable {

    private Long id;
    private Long version;
    private String errorDescription;
    private Date modifiedDate;
    private Date approvedDate;

    private int preparedStatus;

    private String name;
    private String surname;
    private String engName;
    private String engSurname;
    private String lastName;
    private String email;
    private String telephoneNum;
    private String skype;
    private String photoPath;

    private ResumeStatus resumeStatus;
    private DevResumeDetail devResumeDetail;
    private QAResumeDetail qaResumeDetail;

    private User user;
    private Set<ResumeKnowledge> resumeKnowledges = new HashSet<ResumeKnowledge>(0);

    public Resume() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResumeStatus getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(ResumeStatus resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getName() {
        return name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getEngSurname() {
        return engSurname;
    }

    public void setEngSurname(String engSurname) {
        this.engSurname = engSurname;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public DevResumeDetail getDevResumeDetail() {
        return devResumeDetail;
    }

    public void setDevResumeDetail(DevResumeDetail devResumeDetail) {
        this.devResumeDetail = devResumeDetail;
    }

    public QAResumeDetail getQaResumeDetail() {
        return qaResumeDetail;
    }

    public void setQaResumeDetail(QAResumeDetail qaResumeDetail) {
        this.qaResumeDetail = qaResumeDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ResumeKnowledge> getResumeKnowledges() {
        return resumeKnowledges;
    }

    public void setResumeKnowledges(Set<ResumeKnowledge> resumeKnowledges) {
        this.resumeKnowledges = resumeKnowledges;
    }

    public int getPreparedStatus() {
        return preparedStatus;
    }

    public void setPreparedStatus(int preparedStatus) {
        this.preparedStatus = preparedStatus;
    }
}