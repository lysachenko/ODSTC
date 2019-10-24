package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.EditQAResumeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditQAResumeHandler extends AbstractActionHandler<EditQAResumeAction, NoResult> {

    @Autowired
    private ResumeService resumeService;

    public EditQAResumeHandler() {
    }

    @Override
    protected NoResult process(EditQAResumeAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getUserId();

        resumeService.editQAResume(userId, action.getQaResumeDetailDTO());

        return new NoResult();
    }

    @Override
    public Class<EditQAResumeAction> getActionType() {
        return EditQAResumeAction.class;
    }
}
