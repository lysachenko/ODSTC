package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.interview.GetInterviewSlotListResult;
import com.netcracker.tc.shared.action.interview.GetUserInterviewListAction;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserInterviewListHandler extends AbstractActionHandler<GetUserInterviewListAction, GetInterviewSlotListResult> {

    @Autowired
    private InterviewService interviewService;

    public GetUserInterviewListHandler() {
    }

    @Override
    protected GetInterviewSlotListResult process(GetUserInterviewListAction action, ExecutionContext context) throws ServiceException, ActionException {
        PagingLoadResultDTO<InterviewSlot> userResult = interviewService.getInterviewSlots(action.getPagingLoadConfig());

        return new GetInterviewSlotListResult(null);
    }

    @Override
    public Class<GetUserInterviewListAction> getActionType() {
        return GetUserInterviewListAction.class;
    }
}