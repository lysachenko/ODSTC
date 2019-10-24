package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import com.netcracker.tc.shared.action.interview.CancelInterviewAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelInterviewHandler extends AbstractActionHandler<CancelInterviewAction, NoResult> {

    @Autowired
    private InterviewService interviewService;

    public CancelInterviewHandler() {
    }

    @Override
    protected NoResult process(CancelInterviewAction action, ExecutionContext context) throws ServiceException, ActionException, SessionExpiredException {
        Long userId = Session.getExistUserId();

        interviewService.cancelInterview(userId);

        return new NoResult();
    }

    @Override
    public Class<CancelInterviewAction> getActionType() {
        return CancelInterviewAction.class;
    }
}