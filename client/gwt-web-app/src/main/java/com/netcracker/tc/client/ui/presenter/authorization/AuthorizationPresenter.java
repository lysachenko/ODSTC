package com.netcracker.tc.client.ui.presenter.authorization;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.shared.action.LoginAction;
import com.netcracker.tc.shared.action.LoginResult;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.UserStatusDTO;

public class AuthorizationPresenter extends PresenterWidget<AuthorizationPresenter.AuthorizationView> {

    @Inject
    private DispatchAsync dispatcher;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private PlaceManager placeManager;

    @Inject
    public AuthorizationPresenter(EventBus eventBus, AuthorizationView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        getView().getAuthorizationButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                authorization();
            }
        });

        getView().getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getView().hide();
            }
        });
    }

    public void authorization() {
        if (!getView().isValid()){
            return;
        }
        String login = getView().getLoginField().getText();
        String password = getView().getPasswordField().getText();
        getDispatcher().execute(new LoginAction(login, password), new DefaultAsyncCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult result) {
                getView().hideErrorMessage();

                currentUser.setUser(result.getUser());
                if (result.getUser().getStudentDetail() != null) {
                    currentUser.setPosition(result.getUser().getStudentDetail().getPosition());
                }

                LoginAuthenticatedEvent.fire(getEventBus(), currentUser);

                //TODO fix next code. Create another layout widget without header menu bar.

                if (currentUser.getUser().getRole().isStudent()) {
                    UserStatusDTO userStatusDTO = currentUser.getUser().getStudentDetail().getUserStatus();
                    if (userStatusDTO != null) {
                        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(userStatusDTO.getPresenterName()).build());
                    }
                }

                if (currentUser.getUser().getRole().isAdmin()){
                    placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.Admin.USER_LIST).build());
                }

                if (currentUser.getUser().getRole().isHR() || currentUser.getUser().getRole().isSimpleHR()){
                    placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.Hr.USER_INTERVIEW).build());
                }

                if (currentUser.getUser().getRole().isInterviewer()){
                    placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.Interviewer.USERS).build());
                }

                //TODO ....

                getView().hide();
            }

            @Override
            public void onFailure(Throwable caught) {
                getView().showErrorMessage(caught.getMessage());
            }
        });
    }

    private DispatchAsync getDispatcher() {
        return dispatcher;
    }

    public interface AuthorizationView extends PopupView {

        Button getCancelButton();

        Button getAuthorizationButton();

        PasswordTextBox getPasswordField();

        TextBox getLoginField();

        void showErrorMessage(String message);

        void hideErrorMessage();

        boolean isValid();
    }

    public void show(){
        getView().hideErrorMessage();
        getView().show();
    }
}
