package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.user.ResetPasswordAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordHandler extends AbstractActionHandler<ResetPasswordAction, NoResult> {

    @Autowired
    private UserService userService;

    public ResetPasswordHandler() {
    }

    @Override
    protected NoResult process(ResetPasswordAction action, ExecutionContext context) throws ServiceException, ActionException {
        userService.resetPassword(action.getUserId(), action.getUserPassword());

        return new NoResult();
    }

    @Override
    public Class<ResetPasswordAction> getActionType() {
        return ResetPasswordAction.class;
    }
}
