package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

import java.util.Date;

public class GetUserInterviewResult implements Result {

    private InterviewSlotDTO interviewSlot;
    private String userName;

    public GetUserInterviewResult(InterviewSlotDTO interviewSlot, String userName) {
        this.interviewSlot = interviewSlot;
        this.userName = userName;
    }

    public GetUserInterviewResult() {
    }

    public InterviewSlotDTO getInterviewSlot() {
        return interviewSlot;
    }

    public void setInterviewSlot(InterviewSlotDTO interviewSlot) {
        this.interviewSlot = interviewSlot;
    }

    public String getUserName() {
        return userName;
    }
}