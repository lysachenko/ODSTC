package com.netcracker.tc.shared.action;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import java.util.Date;

/**
 * @author unconsionable
 */
public class LoginAction extends UnsecuredActionImpl<LoginResult> {

    private String login;
    private String password;
    private long timezoneOffset;

    public LoginAction(String login, String password) {
        timezoneOffset = new Date().getTimezoneOffset();
        this.login = login;
        this.password = password;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private LoginAction() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getTimezoneOffset() {
        return timezoneOffset;
    }
}
