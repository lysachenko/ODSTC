package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.api.SettingsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.CreateDevResumeAction;
import com.netcracker.tc.shared.action.resume.IsDevResumeValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateDevResumeHandler extends AbstractActionHandler<CreateDevResumeAction, IsDevResumeValid> {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private SettingsService settingsService;

    public CreateDevResumeHandler() {
    }

    @Override
    protected IsDevResumeValid process(CreateDevResumeAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();
        
        boolean isValid = resumeService.checkResume(action.getResumeDTO());
        resumeService.createDevResume(userId, action.getResumeDTO(), isValid);       

        return new IsDevResumeValid(isValid);
    }

    @Override
    public Class<CreateDevResumeAction> getActionType() {
        return CreateDevResumeAction.class;
    }
}