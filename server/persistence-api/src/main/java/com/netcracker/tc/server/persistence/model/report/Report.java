package com.netcracker.tc.server.persistence.model.report;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

    private String student;
    private String dateInterview;
    private Long startInterview;
    private Long endInterview;
    private Integer hrTime;
    private Integer interviewTime;

    public Report() {
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getDateInterview() {
        return dateInterview;
    }

    public void setDateInterview(Date dateInterview) {
        this.dateInterview = dateInterview.toString();
    }

    public Long getStartInterview() {
        return startInterview;
    }

    public void setStartInterview(Long startInterview) {
        this.startInterview = startInterview;
    }

    public Long getEndInterview() {
        return endInterview;
    }

    public void setEndInterview(Long endInterview) {
        this.endInterview = endInterview;
    }

    public Integer getHrTime() {
        return hrTime;
    }

    public void setHrTime(Integer hrTime) {
        this.hrTime = hrTime;
    }

    public Integer getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Integer interviewTime) {
        this.interviewTime = interviewTime;
    }
}
