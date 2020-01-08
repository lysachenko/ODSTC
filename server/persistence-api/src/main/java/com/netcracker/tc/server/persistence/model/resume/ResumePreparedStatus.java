package com.netcracker.tc.server.persistence.model.resume;

public enum ResumePreparedStatus {
    EMPTY(0),   // пользователь создан. резюме пусто и закрыто для HR

    CREATED(1), // резюме заполнено первый раз.
                      // открыто для HR, открыто для редактирования и повторной отправки

    EDITED(2),  // резюме редактируется.
                      // закрыто для HR, открыто для редактирования и повторной отправки

    SUBMITTED(3); // резюме отправлено окончательно.
                    // открыто для HR, закрыто для редактирования и повторной отправки

    private int value;

    ResumePreparedStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
