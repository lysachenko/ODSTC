package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.UserDTO;

public class RegistrationStep2Action extends UnsecuredActionImpl<NoResult> {

    private UserDTO user;
    private String captcha;
    private String emailCode;

    public RegistrationStep2Action(UserDTO user, String captcha, String emailCode) {
        this.user = user;
        this.captcha = captcha;
        this.emailCode = emailCode;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private RegistrationStep2Action() {
    }

    public UserDTO getUser() {
        return user;
    }

    public String getCaptcha() {
        return captcha;
    }

    public String getEmailCode() {
        return emailCode;
    }
}