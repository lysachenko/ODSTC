package com.netcracker.tc.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.exception.SessionExpiredException;

public abstract class AbstractActionHandler<A extends Action<R>, R extends Result> implements ActionHandler<A, R> {

    @Override
    public R execute(A action, ExecutionContext context) throws ActionException {
        try {
            return process(action, context);
        } catch (ServiceException e) {
            throw new ActionException(e.getMessage());
        }
    }

    protected abstract R process(A action, ExecutionContext context) throws ServiceException, ActionException, SessionExpiredException;

    @Override
    public void undo(A action, R result, ExecutionContext context) throws ActionException {
    }
}
