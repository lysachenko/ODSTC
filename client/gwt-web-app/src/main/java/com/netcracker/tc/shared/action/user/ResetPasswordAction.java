package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class ResetPasswordAction extends UnsecuredActionImpl<NoResult> {

    private long userId;
    private String userPassword;

    public ResetPasswordAction(long userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private ResetPasswordAction(){
    }

    public long getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}