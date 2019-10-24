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
import com.netcracker.tc.server.util.MD5;
import com.netcracker.tc.shared.action.user.RegistrationStep1Action;
import nl.captcha.Captcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationStep1Handler extends AbstractActionHandler<RegistrationStep1Action, NoResult> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationStep1Handler.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

    public RegistrationStep1Handler() {
    }

    @Override
    protected NoResult process(RegistrationStep1Action action, ExecutionContext context) throws ServiceException, ActionException {
        Captcha captcha = Session.getCaptcha();

        LOGGER.error("captcha=" + captcha);
        LOGGER.error("action.getCaptcha()="+action.getCaptcha());

        if (captcha == null || Strings.isNullOrEmpty(action.getCaptcha())){
            throw new ServiceException("Невозможно проверить правильность капчи");
        }

        if (!captcha.isCorrect(action.getCaptcha())){
            throw new ServiceException("Введен неправильный код. Пожалуйста повторите попытку");
        }

        userService.isLoginFree(action.getUser().getLogin());

//        String registrationEmailCode = MD5.hash(action.getUser().getLogin());
//        String registrationEmailCode = "NC";
        //TODO anky0315
//        mailService.sendRegistrationMessage(action.getUser().getLogin(), action.getUser().getPassword(), registrationEmailCode);
//        Session.setRegistrationEmailCode(registrationEmailCode);

        userService.addStudent(action.getUser());
        return new NoResult();
    }

    @Override
    public Class<RegistrationStep1Action> getActionType() {
        return RegistrationStep1Action.class;
    }
}