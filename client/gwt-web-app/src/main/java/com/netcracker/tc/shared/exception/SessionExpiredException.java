package com.netcracker.tc.shared.exception;

import com.gwtplatform.dispatch.shared.ActionException;

public class SessionExpiredException extends ActionException {
    private Long userId;

    public SessionExpiredException() {
    }

    public SessionExpiredException(String message) {
        super(message);
    }

    public SessionExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionExpiredException(String message, Long userId) {
        super(message);

        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}