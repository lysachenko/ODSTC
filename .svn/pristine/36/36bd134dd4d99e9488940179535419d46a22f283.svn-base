package com.netcracker.tc.client.ui.widget.navigation;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.client.event.LoginAuthenticatedEventHandler;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.UserDTO;

public class NavigationBarPresenterWidget extends PresenterWidget<NavigationBarPresenterWidget.NavigationBarView>
        implements NavigationUiHandlers, LoginAuthenticatedEventHandler {

    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    @Inject
    CurrentUser currentUser;

    @Inject
    public NavigationBarPresenterWidget(EventBus eventBus, NavigationBarView view,
                                        final DispatchAsync dispatcher,
                                        final PlaceManager placeManager) {
        super(eventBus, view);

        this.dispatcher = dispatcher;
        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    protected void onBind() {
        addRegisteredHandler(LoginAuthenticatedEvent.getType(), this);

        updateNavigation(currentUser.getUser());
    }

    @Override
    public void navigate(String pageToken) {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(pageToken).build());
    }

    @Override
    public void onLogin(LoginAuthenticatedEvent event) {
        updateNavigation(event.getCurrentUser().getUser());
    }

    private void updateNavigation(UserDTO user) {
        if (user == null) {
            getView().createNavigation(null);
            return;
        }

        if (user.getRole().isStudent()) {
            if (user.getStudentDetail().getUserStatus() != null) {
                return;
            }
        }

        getView().createNavigation(user.getRole().getId());
    }

    @Override
    public void onLogout() {
        updateNavigation(null);
    }

    public interface NavigationBarView extends View, HasUiHandlers<NavigationUiHandlers> {

        void createNavigation(Long role);
    }
}