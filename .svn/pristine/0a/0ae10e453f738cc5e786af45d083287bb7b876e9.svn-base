package com.netcracker.tc.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.LoginAction;
import com.netcracker.tc.shared.action.LoginResult;
import com.netcracker.tc.shared.model.user.UserDTO;
import com.netcracker.tc.shared.verifier.LoginVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class LoginHandler extends AbstractActionHandler<LoginAction, LoginResult> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHandler.class);
    @Autowired
    private UserService userService;

    public LoginHandler() {
    }

    @Override
    protected LoginResult process(LoginAction action, ExecutionContext context) throws ServiceException, ActionException {
        String login = action.getLogin();
        String password = action.getPassword();

        if (!LoginVerifier.isValid(login, password)) {
            throw new ActionException("Login or password incorrect");
        }

        UserDTO user = userService.loginUser(login, password);

        Session.setUserId(user.getId());
        Session.setTimezoneOffset(action.getTimezoneOffset() * 60000 * (-1));

        LOGGER.info("Server timezone: {}", GregorianCalendar.getInstance().getTimeZone());
        LOGGER.info("User timezoneOffset: {}. Server timezoneOffset: {}", action.getTimezoneOffset(), new Date().getTimezoneOffset());

        return new LoginResult(user);
    }

    @Override
    public Class<LoginAction> getActionType() {
        return LoginAction.class;
    }
}