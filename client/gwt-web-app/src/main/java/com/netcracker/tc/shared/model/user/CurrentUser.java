package com.netcracker.tc.shared.model.user;

import com.netcracker.tc.server.persistence.model.user.Position;

/**
 * @author unconsionable
 */
public class CurrentUser {

    private UserDTO user;
    private PositionDTO position;

    public CurrentUser(UserDTO user) {
        this.user = user;
    }

    public CurrentUser() {
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }
}