package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class AddUserAction extends UnsecuredActionImpl<NoResult> {

    private UserDTO user;

    public AddUserAction(UserDTO user) {
        this.user = user;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private AddUserAction() {
    }

    public UserDTO getUser() {
        return user;
    }
}