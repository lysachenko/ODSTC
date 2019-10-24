package com.netcracker.tc.shared.model.interview;

import com.netcracker.tc.shared.model.user.UserDTO;

import java.io.Serializable;
import java.util.Date;

public class InterviewSlotDTO implements Serializable {

    private Long id;
    private UserDTO user;
    private Long time;

    private InterviewDTO interview;
    private InterviewResultDTO interviewResult;

    public InterviewSlotDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public InterviewDTO getInterview() {
        return interview;
    }

    public void setInterview(InterviewDTO interview) {
        this.interview = interview;
    }

    public InterviewResultDTO getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(InterviewResultDTO interviewResult) {
        this.interviewResult = interviewResult;
    }

    public Date getInterviewDate() {
        return new Date(interview.getInterviewDate().getTime() + time);
    }
}