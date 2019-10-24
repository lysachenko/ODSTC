package com.netcracker.tc.client.callback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.tc.shared.exception.SessionExpiredException;

public abstract class DefaultAsyncCallback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        if (caught instanceof SessionExpiredException)
            Window.Location.reload();
        else
            Window.alert(caught.getMessage());
    }
}
