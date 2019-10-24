package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.user.UserDTO;

import java.util.List;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class UserListResult implements Result {

    private List<UserDTO> users;

    public UserListResult(List<UserDTO> users) {
        this.users = users;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    public UserListResult(){

    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
