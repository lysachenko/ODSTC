package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by unconsionable on 21.07.2014.
 */
public class DeleteInterviewAction extends UnsecuredActionImpl<NoResult> {

    private Long interviewId;

    public DeleteInterviewAction(Long interviewId) {
        this.interviewId = interviewId;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private DeleteInterviewAction(){
    }

    public Long getInterviewId() {
        return interviewId;
    }
}