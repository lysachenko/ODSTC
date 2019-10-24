package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class ChangePasswordAction extends UnsecuredActionImpl<NoResult> {

    private long userId;
    private String currentPassword;
    private String newPassword;

    public ChangePasswordAction(long userId, String currentPassword, String newPassword) {
        this.userId = userId;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private ChangePasswordAction(){
    }

    public long getUserId() {
        return userId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}