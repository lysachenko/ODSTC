package com.netcracker.tc.shared.action.user;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 16.07.2014.
 */
public class RegistrationStep1Action extends UnsecuredActionImpl<NoResult> {

    private UserDTO user;
    private String captcha;

    public RegistrationStep1Action(UserDTO user, String captcha) {
        this.user = user;
        this.captcha = captcha;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private RegistrationStep1Action() {
    }

    public UserDTO getUser() {
        return user;
    }

    public String getCaptcha() {
        return captcha;
    }
}