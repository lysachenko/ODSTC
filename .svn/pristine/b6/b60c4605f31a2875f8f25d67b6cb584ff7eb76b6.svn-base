package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.EditPositionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditPositionHandler extends AbstractActionHandler<EditPositionAction, NoResult> {

    @Autowired
    private ResumeService resumeService;

    public EditPositionHandler() {
    }

    @Override
    protected NoResult process(EditPositionAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        resumeService.editPosition(userId, action.getPositionDTO());

        return new NoResult();
    }

    @Override
    public Class<EditPositionAction> getActionType() {
        return EditPositionAction.class;
    }
}
