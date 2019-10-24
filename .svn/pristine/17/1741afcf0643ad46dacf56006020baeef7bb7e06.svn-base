package com.netcracker.tc.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.netcracker.tc.shared.model.user.CurrentUser;

/**
 * @author unconsionable
 */
public class LoginAuthenticatedEvent extends GwtEvent<LoginAuthenticatedEventHandler> {

    private static final Type<LoginAuthenticatedEventHandler> TYPE = new Type<LoginAuthenticatedEventHandler>();
    private final CurrentUser currentUser;

    public LoginAuthenticatedEvent(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public static Type<LoginAuthenticatedEventHandler> getType() {
        return TYPE;
    }

    public static void fire(EventBus eventBus, CurrentUser currentUser) {
        eventBus.fireEvent(new LoginAuthenticatedEvent(currentUser));
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    @Override
    protected void dispatch(LoginAuthenticatedEventHandler handler) {
        if (currentUser.getUser() == null) {
            handler.onLogout();
        } else {
            handler.onLogin(this);
        }
    }

    @Override
    public Type<LoginAuthenticatedEventHandler> getAssociatedType() {
        return getType();
    }
}