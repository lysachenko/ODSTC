package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.EditDevResumeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditDevResumeHandler extends AbstractActionHandler<EditDevResumeAction, NoResult> {

    @Autowired
    private ResumeService resumeService;

    public EditDevResumeHandler() {
    }

    @Override
    protected NoResult process(EditDevResumeAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        resumeService.editDevResume(userId, action.getResumeDTO());

        return new NoResult();
    }

    @Override
    public Class<EditDevResumeAction> getActionType() {
        return EditDevResumeAction.class;
    }
}
