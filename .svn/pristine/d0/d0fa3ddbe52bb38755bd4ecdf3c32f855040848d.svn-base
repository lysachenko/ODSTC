package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.interview.EditDevInterviewResultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditDevInterviewResultHandler extends AbstractActionHandler<EditDevInterviewResultAction, NoResult> {

    @Autowired
    private InterviewService interviewService;

    public EditDevInterviewResultHandler() {
    }

    @Override
    protected NoResult process(EditDevInterviewResultAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        interviewService.editDEVInterviewResult(action.getInterviewResultDTO(), userId);

        return new NoResult();
    }

    @Override
    public Class<EditDevInterviewResultAction> getActionType() {
        return EditDevInterviewResultAction.class;
    }

}