package com.netcracker.tc.shared.action;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * @author unconsionable
 */
public class LoginResult implements Result {

    private UserDTO user;

    public LoginResult(UserDTO user) {
        this.user = user;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private LoginResult() {
    }

    public UserDTO getUser() {
        return user;
    }
}