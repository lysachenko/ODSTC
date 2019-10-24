package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.interview.DeleteInterviewAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteInterviewHandler extends AbstractActionHandler<DeleteInterviewAction, NoResult> {

    @Autowired
    private InterviewService interviewService;

    public DeleteInterviewHandler() {
    }

    @Override
    protected NoResult process(DeleteInterviewAction action, ExecutionContext context) throws ServiceException, ActionException {
        interviewService.deleteInterview(action.getInterviewId());

        return new NoResult();
    }

    @Override
    public Class<DeleteInterviewAction> getActionType() {
        return DeleteInterviewAction.class;
    }
}
