package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.user.DeleteUserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserHandler extends AbstractActionHandler<DeleteUserAction, NoResult> {

    @Autowired
    private UserService userService;

    public DeleteUserHandler() {
    }

    @Override
    protected NoResult process(DeleteUserAction action, ExecutionContext context) throws ServiceException, ActionException {
        userService.deleteUser(action.getUserId());

        return new NoResult();
    }

    @Override
    public Class<DeleteUserAction> getActionType() {
        return DeleteUserAction.class;
    }
}