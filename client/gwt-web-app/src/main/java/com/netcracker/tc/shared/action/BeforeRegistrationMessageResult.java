package com.netcracker.tc.shared.action;

import com.gwtplatform.dispatch.rpc.shared.Result;


public class BeforeRegistrationMessageResult implements Result {
    private String message;

    public BeforeRegistrationMessageResult(String message) {
        this.message = message;
    }

    public BeforeRegistrationMessageResult() {
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
