package com.netcracker.tc.shared.action;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.user.UserDTO;

public class InitResult implements Result {

    private UserDTO user;

    public InitResult(UserDTO user) {
        this.user = user;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private InitResult() {
    }

    public UserDTO getUser() {
        return user;
    }
}
