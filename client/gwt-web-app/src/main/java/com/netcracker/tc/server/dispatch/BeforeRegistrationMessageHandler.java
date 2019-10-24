package com.netcracker.tc.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.service.api.SettingsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.BeforeRegistrationMessageAction;
import com.netcracker.tc.shared.action.BeforeRegistrationMessageResult;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BeforeRegistrationMessageHandler extends AbstractActionHandler<BeforeRegistrationMessageAction, BeforeRegistrationMessageResult> {

    @Override
    protected BeforeRegistrationMessageResult process(BeforeRegistrationMessageAction action, ExecutionContext context) throws ServiceException, ActionException, SessionExpiredException {
        if(!settingsService.getBeforeRegistrationMessage().equals(action.getMessage()) && !action.getMessage().isEmpty()){
                settingsService.setBeforeRegistrationMessage(action.getMessage());
            }

        return new BeforeRegistrationMessageResult(settingsService.getBeforeRegistrationMessage());
    }

    @Override
    public Class<BeforeRegistrationMessageAction> getActionType() {
        return BeforeRegistrationMessageAction.class;
    }


    @Autowired
    private SettingsService settingsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BeforeRegistrationMessageHandler.class);

}
