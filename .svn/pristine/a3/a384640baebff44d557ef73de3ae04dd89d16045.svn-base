package com.netcracker.tc.server.dispatch.interview;

import com.google.inject.Provider;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.interview.ActivateInterviewAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ActivateInterviewHandler extends AbstractActionHandler<ActivateInterviewAction, NoResult> {

//    @Autowired
//    Provider<HttpServletRequest> requestProvider;
    @Autowired
    private InterviewService interviewService;

    public ActivateInterviewHandler() {
    }

    @Override
    protected NoResult process(ActivateInterviewAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = null;
        // (Long) requestProvider.get().getSession().getAttribute("userId");

        interviewService.activateInterview(action.getInterviewId(), action.isActivate());

        return new NoResult();
    }

    @Override
    public Class<ActivateInterviewAction> getActionType() {
        return ActivateInterviewAction.class;
    }
}
