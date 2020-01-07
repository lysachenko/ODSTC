package com.netcracker.tc.server.persistence.model.resume;

public enum ResumePreparedStatus {
    EMPTY(0),
    CREATED(1),
    EDITED(2),
    SUBMITTED(3);

    private int value;

    ResumePreparedStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
