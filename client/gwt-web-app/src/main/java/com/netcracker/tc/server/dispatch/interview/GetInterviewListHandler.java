package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.interview.GetInterviewListAction;
import com.netcracker.tc.shared.action.interview.GetInterviewListResult;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetInterviewListHandler extends AbstractActionHandler<GetInterviewListAction, GetInterviewListResult> {

    @Autowired
    private InterviewService interviewService;

    public GetInterviewListHandler() {
    }

    @Override
    protected GetInterviewListResult process(GetInterviewListAction action, ExecutionContext context) throws ServiceException, ActionException {
        PagingLoadResultDTO<InterviewDTO> userResult = interviewService.getInterviews(action.getPagingLoadConfig());

        return new GetInterviewListResult(userResult);
    }

    @Override
    public Class<GetInterviewListAction> getActionType() {
        return GetInterviewListAction.class;
    }
}
