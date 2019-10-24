package com.netcracker.tc.client.ui.widget.navigation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.client.event.LoginAuthenticatedEventHandler;
import com.netcracker.tc.client.ui.presenter.authorization.AuthorizationPresenter;
import com.netcracker.tc.client.ui.presenter.authorization.RegistrationPresenter;
import com.netcracker.tc.client.ui.widget.dialog.AlertDialogPresenter;
import com.netcracker.tc.shared.action.CheckRegistrationStatusAction;
import com.netcracker.tc.shared.action.CheckRegistrationStatusResult;
import com.netcracker.tc.shared.action.BeforeRegistrationMessageAction;
import com.netcracker.tc.shared.action.BeforeRegistrationMessageResult;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.UserDTO;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginLogoutPresenterWidget extends PresenterWidget<LoginLogoutPresenterWidget.View> implements LoginAuthenticatedEventHandler {

    @Inject
    private DispatchAsync dispatcher;    
    @Inject
    private PlaceManager placeManager;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private AuthorizationPresenter authorizationPresenter;
    @Inject
    private RegistrationPresenter registrationPresenter;
    @Inject
    private AlertDialogPresenter alertDialogPresenter;

    private LoginNavigationWidget loginWidget;
    private LogoutNavigationWidget logoutWidget;
    private static Logger LOGGER = Logger.getLogger(LoginLogoutPresenterWidget.class.toString());

    @Inject
    public LoginLogoutPresenterWidget(EventBus eventBus, View view) {
        super(eventBus, view);

        loginWidget = new LoginNavigationWidget();
        logoutWidget = new LogoutNavigationWidget();
    }

    @Override
    protected void onBind() {
        loginWidget.getSignInButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                authorizationPresenter.show();
            }
        });
        logoutWidget.getLogoutButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                currentUser.setUser(null);
                LoginAuthenticatedEvent.fire(getEventBus(), currentUser);

                placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.HOME).build());
            }
        });
        loginWidget.getRegistrationButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                dispatcher.execute(new BeforeRegistrationMessageAction(), new DefaultAsyncCallback<BeforeRegistrationMessageResult>() {
                    @Override
                    public void onSuccess(BeforeRegistrationMessageResult result) {
                       final String message = result.getMessage();

                        dispatcher.execute(new CheckRegistrationStatusAction(), new DefaultAsyncCallback<CheckRegistrationStatusResult>() {
                            @Override
                            public void onSuccess(CheckRegistrationStatusResult result) {
                                if(result.getStatus().booleanValue()){
                                    registrationPresenter.show();
                                } else {
                                alertDialogPresenter.show(message);

                                }
                            }
                        });


                    }
                });



            }
        });

        getView().setWidget(loginWidget);

        addRegisteredHandler(LoginAuthenticatedEvent.getType(), this);

        if (currentUser.getUser() != null){
            getView().setWidget(logoutWidget);

            logoutWidget.getUserLabel().setText(currentUser.getUser().getLogin());
        } else {
            onLogout();
        }
    }

    @Override
    public void onLogin(LoginAuthenticatedEvent event) {
        getView().setWidget(logoutWidget);

        UserDTO user = event.getCurrentUser().getUser();

        logoutWidget.getUserLabel().setText(user.getLogin());
    }

    @Override
    public void onLogout() {
        getView().setWidget(loginWidget);
    }

    public interface View extends com.gwtplatform.mvp.client.View {

        void setWidget(Widget widget);
    }
}