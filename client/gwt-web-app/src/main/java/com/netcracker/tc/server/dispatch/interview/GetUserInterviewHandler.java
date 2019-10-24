package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.interview.GetUserInterviewAction;
import com.netcracker.tc.shared.action.interview.GetUserInterviewResult;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserInterviewHandler extends AbstractActionHandler<GetUserInterviewAction, GetUserInterviewResult> {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ResumeService resumeService;

    public GetUserInterviewHandler() {
    }

    @Override
    protected GetUserInterviewResult process(GetUserInterviewAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        InterviewSlotDTO interviewSlot = interviewService.getActiveUserInterview(userId);
        ResumeDTO resume = resumeService.getDevResume(userId);

        return new GetUserInterviewResult(interviewSlot, resume.getName());
    }

    @Override
    public Class<GetUserInterviewAction> getActionType() {
        return GetUserInterviewAction.class;
    }
}
