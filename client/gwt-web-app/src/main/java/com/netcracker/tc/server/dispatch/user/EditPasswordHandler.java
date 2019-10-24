package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.user.EditPasswordAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditPasswordHandler extends AbstractActionHandler<EditPasswordAction, NoResult> {

    @Autowired
    private UserService userService;

    public EditPasswordHandler() {
    }

    @Override
    protected NoResult process(EditPasswordAction action, ExecutionContext context) throws ServiceException, ActionException {
        userService.changePassword(action.getUserId(), action.getCurrentPassword(), action.getNewPassword());

        return new NoResult();
    }

    @Override
    public Class<EditPasswordAction> getActionType() {
        return EditPasswordAction.class;
    }
}
