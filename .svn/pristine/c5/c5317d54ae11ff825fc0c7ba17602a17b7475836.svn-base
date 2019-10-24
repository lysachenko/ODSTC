package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.interview.GetAvailableInterviewAction;
import com.netcracker.tc.shared.action.interview.GetAvailableInterviewResult;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAvailableInterviewHandler extends AbstractActionHandler<GetAvailableInterviewAction, GetAvailableInterviewResult> {

    @Autowired
    private InterviewService interviewService;

    public GetAvailableInterviewHandler() {
    }

    @Override
    protected GetAvailableInterviewResult process(GetAvailableInterviewAction action, ExecutionContext context) throws ServiceException, ActionException {
        List<AvailableInterviewDTO> availableInterviewDTOs = interviewService.getAvailableInterviewList(action.getPositionDTO());

        return new GetAvailableInterviewResult(availableInterviewDTOs);
    }

    @Override
    public Class<GetAvailableInterviewAction> getActionType() {
        return GetAvailableInterviewAction.class;
    }
}
