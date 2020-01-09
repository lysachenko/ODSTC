package com.netcracker.tc.server.persistence.model.resume;

public class ResumePreparedStatus {
    public final static int EMPTY = 0; // пользователь создан. резюме пусто и закрыто для HR

    public final static int CREATED = 1;// резюме заполнено первый раз.
    // открыто для HR, открыто для редактирования и повторной отправки

    public final static int EDITED = 2;// резюме редактируется.
    // закрыто для HR, открыто для редактирования и повторной отправки

    public final static int SUBMITTED = 3;// резюме отправлено окончательно.
    // открыто для HR, закрыто для редактирования и повторной отправки

}
