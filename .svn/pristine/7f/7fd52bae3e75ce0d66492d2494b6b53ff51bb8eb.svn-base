package com.netcracker.tc.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;

public class AppLoadingEvent extends GwtEvent<AppLoadingEventHandler> {

    public static final Type<AppLoadingEventHandler> TYPE = new Type<AppLoadingEventHandler>();

    boolean isComplete;

    public static Type<AppLoadingEventHandler> getType() {
        return TYPE;
    }

    public static void fire(EventBus eventBus, boolean complete) {
        eventBus.fireEvent(new AppLoadingEvent(complete));
    }

    public AppLoadingEvent(boolean complete) {
        isComplete = complete;
    }

    @Override
    protected void dispatch(AppLoadingEventHandler handler) {
        handler.onAppLoadingEvent(isComplete);
    }

    @Override
    public Type<AppLoadingEventHandler> getAssociatedType() {
        return getType();
    }

}