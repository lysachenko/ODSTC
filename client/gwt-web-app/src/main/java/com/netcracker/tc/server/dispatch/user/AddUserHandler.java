package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.user.AddUserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserHandler extends AbstractActionHandler<AddUserAction, NoResult> {

    @Autowired
    private UserService userService;

    public AddUserHandler() {
    }

    @Override
    protected NoResult process(AddUserAction action, ExecutionContext context) throws ServiceException, ActionException {
        userService.addUser(action.getUser());

        return new NoResult();
    }

    @Override
    public Class<AddUserAction> getActionType() {
        return AddUserAction.class;
    }
}
