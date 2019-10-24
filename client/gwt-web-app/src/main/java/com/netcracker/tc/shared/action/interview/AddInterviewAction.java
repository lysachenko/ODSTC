package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.interview.InterviewDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class AddInterviewAction extends UnsecuredActionImpl<NoResult> {

    private InterviewDTO interviewDTO;

    public AddInterviewAction(InterviewDTO interviewDTO) {
        this.interviewDTO = interviewDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private AddInterviewAction() {
    }

    public InterviewDTO getInterviewDTO() {
        return interviewDTO;
    }
}