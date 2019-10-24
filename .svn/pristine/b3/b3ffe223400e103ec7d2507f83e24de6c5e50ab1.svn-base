package com.netcracker.tc.server.dispatch.user;

import com.google.common.base.Strings;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.MailService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.user.RegistrationStep2Action;
import nl.captcha.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationStep2Handler extends AbstractActionHandler<RegistrationStep2Action, NoResult> {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

    public RegistrationStep2Handler() {
    }

    @Override
    protected NoResult process(RegistrationStep2Action action, ExecutionContext context) throws ServiceException, ActionException {
        Captcha captcha = Session.getCaptcha();
        if (captcha == null || Strings.isNullOrEmpty(action.getCaptcha())){
            throw new ServiceException("Невозможно проверить правильность капчи");
        }

        if (!captcha.isCorrect(action.getCaptcha())){
            throw new ServiceException("Капча введена неправильно");
        }

        /*if (!Session.getRegistrationEmailCode().equals(action.getEmailCode())){
            throw new ServiceException("Неправильный код подтверждения.");
        }*/

        userService.addStudent(action.getUser());

        return new NoResult();
    }

    @Override
    public Class<RegistrationStep2Action> getActionType() {
        return RegistrationStep2Action.class;
    }
}
