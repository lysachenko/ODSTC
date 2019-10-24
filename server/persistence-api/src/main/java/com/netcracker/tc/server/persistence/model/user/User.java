package com.netcracker.tc.server.persistence.model.user;

import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.resume.Resume;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class User implements Serializable{

    private Long id;

    private String login;
    private String password;
    private Role role;

    private Resume resume;
    private StudentDetail studentDetail;

    private Set<InterviewSlot> interviewSlots = new HashSet<InterviewSlot>(0);

    private Date lastLoginDate;
    private boolean archive;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set<InterviewSlot> getInterviewSlots() {
        return interviewSlots;
    }

    public void setInterviewSlots(Set<InterviewSlot> interviewSlots) {
        this.interviewSlots = interviewSlots;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}