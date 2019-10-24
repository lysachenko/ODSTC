/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.tc.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.service.api.SettingsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.service.impl.SettingsServiceImpl;
import com.netcracker.tc.shared.action.ChangeRegistrationStatusAction;
import com.netcracker.tc.shared.action.ChangeRegistrationStatusResult;
import com.netcracker.tc.shared.action.CheckRegistrationStatusAction;
import com.netcracker.tc.shared.action.CheckRegistrationStatusResult;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author anla1215
 */
@Component
public class ChangeRegistrationStatusHandler extends AbstractActionHandler<ChangeRegistrationStatusAction, ChangeRegistrationStatusResult> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeRegistrationStatusHandler.class);
    
    @Autowired
    private SettingsService settingsService;

    @Override
    protected ChangeRegistrationStatusResult process(ChangeRegistrationStatusAction action, ExecutionContext context) throws ServiceException, ActionException, SessionExpiredException {
        try{
            if(settingsService.getIsRegistrationOpen() == action.getNewStatus()){
                return new ChangeRegistrationStatusResult(false,false);
            } else {
                settingsService.setIsRegistrationOpen(action.getNewStatus());
            }
        } catch (ServiceException ex){
            LOGGER.error("ServiceException: " + ex);
            return new ChangeRegistrationStatusResult(false,true);
        }
        return new ChangeRegistrationStatusResult(true);
    }

    @Override
    public Class<ChangeRegistrationStatusAction> getActionType() {
        return ChangeRegistrationStatusAction.class;
    }
    
    
}
