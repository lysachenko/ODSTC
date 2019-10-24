package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.netcracker.tc.shared.action.user.ResetPasswordAction;

public class ChangePasswordPresenter extends PresenterWidget<ChangePasswordPresenter.ChangePasswordView> {

    private final DispatchAsync dispatcher;
    private UserListPresenter userListPresenter;
    private long userId;

    @Inject
    public ChangePasswordPresenter(EventBus eventBus, ChangePasswordView view, DispatchAsync dispatcher) {
        super(eventBus, view);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onBind() {
        getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dispatcher.execute(new ResetPasswordAction(userId, getView().getPasswordField().getValue()),
                        new AsyncCallback<NoResult>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                Window.alert("Error: " + caught.getMessage());
                            }

                            @Override
                            public void onSuccess(NoResult result) {
                                getView().hide();
                                userListPresenter.reloadUserTable();
                            }
                        });
            }
        });

        getView().getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getView().hide();
            }
        });
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserListPresenter(UserListPresenter userListPresenter) {
        this.userListPresenter = userListPresenter;
    }

    public interface ChangePasswordView extends PopupView {

        PasswordTextBox getPasswordField();

        PasswordTextBox getConfirmPasswordField();

        Button getSaveButton();

        Button getCancelButton();
    }
}