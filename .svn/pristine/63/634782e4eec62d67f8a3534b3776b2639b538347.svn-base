package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.user.GetUserListAction;
import com.netcracker.tc.shared.action.user.GetUserListResult;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserListHandler extends AbstractActionHandler<GetUserListAction, GetUserListResult> {

    @Autowired
    private UserService userService;

    public GetUserListHandler() {
    }

    @Override
    protected GetUserListResult process(GetUserListAction action, ExecutionContext context) throws ServiceException, ActionException {
        PagingLoadResultDTO<UserDTO> userResult = userService.getUsers(action.getPagingLoadConfig(), action.getUserPagingFilterDTO());

        return new GetUserListResult(userResult);
    }

    @Override
    public Class<GetUserListAction> getActionType() {
        return GetUserListAction.class;
    }
}
