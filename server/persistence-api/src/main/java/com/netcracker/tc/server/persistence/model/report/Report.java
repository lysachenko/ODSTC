package com.netcracker.tc.server.persistence.model.report;

import java.util.Date;

public class Report {

    private String student;
    private Date dateInterview;
    private Long startTimeHr;
    private Long endTimeHr;
    private Long startTimeInterviewer;
    private Long endTimeInterviewer;

    public Report() {
    }

    public Report(String student, Date dateInterview, Long startTimeHr, Long endTimeHr, Long startTimeInterviewer, Long endTimeInterviewer) {
        this.student = student;
        this.dateInterview = dateInterview;
        this.startTimeHr = startTimeHr;
        this.endTimeHr = endTimeHr;
        this.startTimeInterviewer = startTimeInterviewer;
        this.endTimeInterviewer = endTimeInterviewer;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Date getDateInterview() {
        return dateInterview;
    }

    public void setDateInterview(Date dateInterview) {
        this.dateInterview = dateInterview;
    }

    public Long getStartTimeHr() {
        return startTimeHr;
    }

    public void setStartTimeHr(Long startTimeHr) {
        this.startTimeHr = startTimeHr;
    }

    public Long getEndTimeHr() {
        return endTimeHr;
    }

    public void setEndTimeHr(Long endTimeHr) {
        this.endTimeHr = endTimeHr;
    }

    public Long getStartTimeInterviewer() {
        return startTimeInterviewer;
    }

    public void setStartTimeInterviewer(Long startTimeInterviewer) {
        this.startTimeInterviewer = startTimeInterviewer;
    }

    public Long getEndTimeInterviewer() {
        return endTimeInterviewer;
    }

    public void setEndTimeInterviewer(Long endTimeInterviewer) {
        this.endTimeInterviewer = endTimeInterviewer;
    }

}
