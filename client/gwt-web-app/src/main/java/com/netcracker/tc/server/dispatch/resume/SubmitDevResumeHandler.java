package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.EditDevResumeAction;
import com.netcracker.tc.shared.action.resume.SubmitDevResumeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubmitDevResumeHandler extends AbstractActionHandler<SubmitDevResumeAction, NoResult> {

    @Autowired
    private ResumeService resumeService;

    public SubmitDevResumeHandler() {
    }

    @Override
    protected NoResult process(SubmitDevResumeAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        resumeService.submitDevResume(userId, action.getResumeDTO());

        return new NoResult();
    }

    @Override
    public Class<SubmitDevResumeAction> getActionType() {
        return SubmitDevResumeAction.class;
    }
}
