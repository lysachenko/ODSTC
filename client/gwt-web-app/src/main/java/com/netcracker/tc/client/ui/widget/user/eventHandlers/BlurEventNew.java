package com.netcracker.tc.client.ui.widget.user.eventHandlers;

import com.google.gwt.event.shared.GwtEvent;
import com.netcracker.tc.client.ui.widget.user.eventHandlers.BlurHandlerNew;

public class BlurEventNew extends GwtEvent<BlurHandlerNew> {

    public static final Type<BlurHandlerNew> TYPE = new Type<BlurHandlerNew>();

    @Override
    public Type<BlurHandlerNew> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BlurHandlerNew blurHandler) {
        blurHandler.onBlur(this);
    }
}
