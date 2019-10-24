package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.MailService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.resume.EditUserStatusAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class EditUserStatusHandler extends AbstractActionHandler<EditUserStatusAction, NoResult> {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

    public EditUserStatusHandler() {
    }

    @Override
    protected NoResult process(EditUserStatusAction action, ExecutionContext context) throws ServiceException, ActionException {

        userService.editUserStatus(action.getUserId(), action.getUserStatusDTO());
                try {
            mailService.sendMessage(Collections.singletonList(userService.getUser(action.getUserId()).getResume().getEmail()),action.getMailResult(), action.getMailSubject());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return new NoResult();
    }

    @Override
    public Class<EditUserStatusAction> getActionType() {
        return EditUserStatusAction.class;
    }

}
