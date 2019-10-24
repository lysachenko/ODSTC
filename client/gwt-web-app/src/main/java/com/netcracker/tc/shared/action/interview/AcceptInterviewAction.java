package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class AcceptInterviewAction extends UnsecuredActionImpl<NoResult> {

    private InterviewSlotDTO interviewSlotDTO;

    public AcceptInterviewAction(InterviewSlotDTO interviewSlotDTO) {
        this.interviewSlotDTO = interviewSlotDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private AcceptInterviewAction() {
    }

    public InterviewSlotDTO getInterviewSlotDTO() {
        return interviewSlotDTO;
    }
}