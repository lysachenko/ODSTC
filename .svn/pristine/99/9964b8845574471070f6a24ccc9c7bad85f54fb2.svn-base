package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by unconsionable on 16.07.2014.
 */
public class ActivateInterviewAction extends UnsecuredActionImpl<NoResult> {

    private Long interviewId;
    private boolean activate;

    public ActivateInterviewAction(Long interviewId, boolean activate) {
        this.interviewId = interviewId;
        this.activate = activate;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private ActivateInterviewAction(){
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public boolean isActivate() {
        return activate;
    }
}
