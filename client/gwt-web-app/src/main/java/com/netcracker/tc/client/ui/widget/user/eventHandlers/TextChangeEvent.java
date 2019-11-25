package com.netcracker.tc.client.ui.widget.user.eventHandlers;

import com.google.gwt.event.shared.GwtEvent;
import com.netcracker.tc.client.ui.widget.user.eventHandlers.TextChangeEventHandler;

public class TextChangeEvent extends GwtEvent<TextChangeEventHandler> {

    public static final Type<TextChangeEventHandler> TYPE = new Type<TextChangeEventHandler>();

    @Override
    public Type<TextChangeEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(TextChangeEventHandler handler) {
        handler.onTextChange(this);
    }
}
