package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.DateUtil;
import com.netcracker.tc.shared.action.interview.AddInterviewAction;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddInterviewHandler extends AbstractActionHandler<AddInterviewAction, NoResult> {

    @Autowired
    private InterviewService interviewService;

    public AddInterviewHandler() {
    }

    @Override
    protected NoResult process(AddInterviewAction action, ExecutionContext context) throws ServiceException, ActionException {
        InterviewDTO interviewDTO = action.getInterviewDTO();

        interviewDTO.setInterviewDate(DateUtil.toServerTimezone(interviewDTO.getInterviewDate()));

        interviewService.addInterview(interviewDTO);

        return new NoResult();
    }

    @Override
    public Class<AddInterviewAction> getActionType() {
        return AddInterviewAction.class;
    }
}
