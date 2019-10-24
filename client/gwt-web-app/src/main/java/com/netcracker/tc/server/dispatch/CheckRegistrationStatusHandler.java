/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.tc.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.service.api.SettingsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.CheckRegistrationStatusAction;
import com.netcracker.tc.shared.action.CheckRegistrationStatusResult;
import com.netcracker.tc.shared.action.interview.AcceptInterviewAction;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author anla1215
 */
@Component
public class CheckRegistrationStatusHandler extends AbstractActionHandler<CheckRegistrationStatusAction, CheckRegistrationStatusResult>{

    @Autowired
    private SettingsService settingsService;

    @Override
    public Class<CheckRegistrationStatusAction> getActionType() {
        return CheckRegistrationStatusAction.class;
    }

    @Override
    protected CheckRegistrationStatusResult process(CheckRegistrationStatusAction action, ExecutionContext context) throws ServiceException, ActionException, SessionExpiredException {
        boolean status = settingsService.getIsRegistrationOpen();
        
        return new CheckRegistrationStatusResult(status);
    }

    
}
