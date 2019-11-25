package com.netcracker.tc.client.ui.widget.user.eventHandlers;

import com.google.gwt.event.shared.GwtEvent;

public class FocusEventNew extends GwtEvent<FocusHandlerNew> {

    public static final Type<FocusHandlerNew> TYPE = new Type<FocusHandlerNew>();

    @Override
    public Type<FocusHandlerNew> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FocusHandlerNew focusHandlerNew) {
        focusHandlerNew.onFocus(this);
    }
}
