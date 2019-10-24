package com.netcracker.tc.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.GatekeeperWithParams;
import com.netcracker.tc.shared.model.user.CurrentUser;

public class LoggedInGatekeeper implements GatekeeperWithParams {

    @Inject
    private CurrentUser currentUser;
    private Long[] availableRoles;

    public LoggedInGatekeeper() {
    }

    public GatekeeperWithParams withParams(String[] params) {
        availableRoles = new Long[params.length];

        for (int i=0; i<params.length; i++){
            availableRoles[i] = Long.valueOf(params[i]);
        }

        return this;
    }

    public boolean canReveal() {
        if (currentUser != null && currentUser.getUser() != null) {
            for (Long roleId: availableRoles){
                if (currentUser.getUser().getRole().getId().equals(roleId)){
                    return true;
                }
            }
        }

        return false;
    }
}