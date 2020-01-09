package com.netcracker.tc.server.spring;

import com.gwtplatform.dispatch.rpc.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.HandlerModule;
import com.gwtplatform.dispatch.rpc.server.spring.LoggerFactoryBean;
import com.gwtplatform.dispatch.rpc.server.spring.actionvalidator.DefaultActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.configuration.DefaultModule;
import com.netcracker.tc.server.dispatch.BeforeRegistrationMessageHandler;
import com.netcracker.tc.server.dispatch.ChangeRegistrationStatusHandler;
import com.netcracker.tc.server.dispatch.CheckRegistrationStatusHandler;
import com.netcracker.tc.server.dispatch.LoginHandler;
import com.netcracker.tc.server.dispatch.interview.*;
import com.netcracker.tc.server.dispatch.resume.*;
import com.netcracker.tc.server.dispatch.user.*;
import com.netcracker.tc.server.util.MD5;
import com.netcracker.tc.shared.action.BeforeRegistrationMessageAction;
import com.netcracker.tc.shared.action.ChangeRegistrationStatusAction;
import com.netcracker.tc.shared.action.CheckRegistrationStatusAction;
import com.netcracker.tc.shared.action.LoginAction;
import com.netcracker.tc.shared.action.common.GetMailListAction;
import com.netcracker.tc.shared.action.interview.*;
import com.netcracker.tc.shared.action.resume.*;
import com.netcracker.tc.shared.action.user.*;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



@Configuration
@Import(DefaultModule.class)
@ImportResource("/META-INF/applicationContext.xml")
@ComponentScan("com.netcracker.tc.server")
@EnableScheduling
public class ServerModule extends HandlerModule {

    private String securityCookieName = "JSESSIONID";

    public ServerModule() {
    }

    @Bean
    public ActionValidator getDefaultActionValidator() {
        return new DefaultActionValidator();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        return mailSender;
    }



    @Bean
    public LoggerFactoryBean getLogger() {
        Logger logger = Logger.getAnonymousLogger();
        logger.setLevel(Level.FINEST);
        return new LoggerFactoryBean(logger);
    }

    @Bean //Override the securityCookieName defined in DefaultModule
    String getSecurityCookieName() {
        return securityCookieName;
    }


    @Override
    protected void configureHandlers() {
        bindUserHandlers();
        bindResumeHandlers();
        bindInterviewHandlers();
        bindCommonHandlers();
    }

    private void bindUserHandlers() {
        bindHandler(LoginAction.class, LoginHandler.class);
        bindHandler(GetUserListAction.class, GetUserListHandler.class);
        bindHandler(GetMailListAction.class, GetMailListHandler.class);
        bindHandler(EditPasswordAction.class, EditPasswordHandler.class);
        bindHandler(DeleteUserAction.class, DeleteUserHandler.class);
        bindHandler(ResetPasswordAction.class, ResetPasswordHandler.class);
        bindHandler(AddUserAction.class, AddUserHandler.class);
        bindHandler(RegistrationStep1Action.class, RegistrationStep1Handler.class);
        bindHandler(RegistrationStep2Action.class, RegistrationStep2Handler.class);
        bindHandler(EditUserStatusAction.class, EditUserStatusHandler.class);
    }

    private void bindResumeHandlers() {
        bindHandler(EditPositionAction.class, EditPositionHandler.class);
        bindHandler(GetDevResumeAction.class, GetDevResumeHandler.class);
        bindHandler(GetQAResumeAction.class, GetQAResumeHandler.class);
        bindHandler(EditDevResumeAction.class, EditDevResumeHandler.class);
        bindHandler(SubmitDevResumeAction.class, SubmitDevResumeHandler.class);
        bindHandler(EditQAResumeAction.class, EditQAResumeHandler.class);
        bindHandler(ActivateInterviewAction.class, ActivateInterviewHandler.class);
        bindHandler(CreateDevResumeAction.class, CreateDevResumeHandler.class);
    }

    private void bindInterviewHandlers() {
        bindHandler(GetUserInterviewListAction.class, GetUserInterviewListHandler.class);
        bindHandler(GetInterviewListAction.class, GetInterviewListHandler.class);
        bindHandler(GetUserInterviewAction.class, GetUserInterviewHandler.class);
        bindHandler(GetAvailableInterviewAction.class, GetAvailableInterviewHandler.class);
        bindHandler(AcceptInterviewAction.class, AcceptInterviewHandler.class);
        bindHandler(AddInterviewAction.class, AddInterviewHandler.class);
        bindHandler(CancelInterviewAction.class, CancelInterviewHandler.class);
        bindHandler(DeleteInterviewAction.class, DeleteInterviewHandler.class);
        bindHandler(GetUserInformationAction.class, GetUserInformationHandler.class);
        bindHandler(EditHRInterviewResultAction.class, EditHRInterviewResultHandler.class);
        bindHandler(EditDevInterviewResultAction.class, EditDevInterviewResultHandler.class);

    }

    private void bindCommonHandlers() {
        bindHandler(CheckRegistrationStatusAction.class, CheckRegistrationStatusHandler.class);
        bindHandler(ChangeRegistrationStatusAction.class, ChangeRegistrationStatusHandler.class);
        bindHandler(BeforeRegistrationMessageAction.class, BeforeRegistrationMessageHandler.class);

    }
}