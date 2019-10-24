package com.netcracker.tc.server.persistence.model.interview;

import com.netcracker.tc.server.persistence.model.user.Position;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class Interview implements Serializable {

    private Long id;
    private Date interviewDate;
    private Long startTime;
    private Long endTime;
    private Integer hrTimeForInterview;
    private Integer interviewerTimeForInterview;
    private Integer totalPlaceCount;
    private Integer availablePlaceCount;
    private Integer interviewerCount;
    private Integer hrCount;
    private Position position;
    private Boolean enable;

    private Set<InterviewSlot> interviewSlots = new HashSet<InterviewSlot>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getHrTimeForInterview() {
        return hrTimeForInterview;
    }

    public void setHrTimeForInterview(Integer hrTimeForInterview) {
        this.hrTimeForInterview = hrTimeForInterview;
    }

    public Integer getInterviewerTimeForInterview() {
        return interviewerTimeForInterview;
    }

    public void setInterviewerTimeForInterview(Integer interviewerTimeForInterview) {
        this.interviewerTimeForInterview = interviewerTimeForInterview;
    }

    public Integer getTotalPlaceCount() {
        return totalPlaceCount;
    }

    public void setTotalPlaceCount(Integer totalPlaceCount) {
        this.totalPlaceCount = totalPlaceCount;
    }

    public Integer getAvailablePlaceCount() {
        return availablePlaceCount;
    }

    public void setAvailablePlaceCount(Integer availablePlaceCount) {
        this.availablePlaceCount = availablePlaceCount;
    }

    public Integer getInterviewerCount() {
        return interviewerCount;
    }

    public void setInterviewerCount(Integer interviewerCount) {
        this.interviewerCount = interviewerCount;
    }

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Set<InterviewSlot> getInterviewSlots() {
        return interviewSlots;
    }

    public void setInterviewSlots(Set<InterviewSlot> interviewSlots) {
        this.interviewSlots = interviewSlots;
    }
}