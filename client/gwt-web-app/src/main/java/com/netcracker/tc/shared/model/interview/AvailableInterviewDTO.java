package com.netcracker.tc.shared.model.interview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvailableInterviewDTO implements Serializable {

    private InterviewDTO interview;

    private List<Long> interviewTimeList;

    public AvailableInterviewDTO() {
        interviewTimeList = new ArrayList<Long>();
    }

    public InterviewDTO getInterview() {
        return interview;
    }

    public void setInterview(InterviewDTO interview) {
        this.interview = interview;
    }

    public List<Long> getInterviewTimeList() {
        return interviewTimeList;
    }

    public void setInterviewTimeList(List<Long> interviewTimeList) {
        this.interviewTimeList = interviewTimeList;
    }
}