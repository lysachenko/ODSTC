package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.ui.widget.simple.RoleListBox;
import com.netcracker.tc.shared.action.user.AddUserAction;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class AddUserPresenter extends PresenterWidget<AddUserPresenter.AddUserView> {

    private final DispatchAsync dispatcher;
    private UserListPresenter userListPresenter;

    @Inject
    public AddUserPresenter(final EventBus eventBus, final AddUserView view, final DispatchAsync dispatcher) {
        super(eventBus, view);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onBind() {
        getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().isValid()) {
                    dispatcher.execute(new AddUserAction(getView().getUserDTO()), new DefaultAsyncCallback<NoResult>() {

                        @Override
                        public void onSuccess(NoResult result) {
                            getView().hide();
                            userListPresenter.reloadUserTable();
                        }
                    });
                }
            }
        });

        getView().getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getView().hide();
            }
        });
    }

    public void setUserListPresenter(UserListPresenter userListPresenter) {
        this.userListPresenter = userListPresenter;
    }

    public interface AddUserView extends PopupView {

        TextBox getLoginField();

        PasswordTextBox getPasswordField();

        RoleListBox getRoleListBox();

        PasswordTextBox getConfirmPasswordField();

        TextBox getNameField();

        TextBox getSurnameField();

        TextBox getEmailField();

        TextBox getTelephoneField();

        TextBox getSkypeField();

        Button getSaveButton();

        Button getCancelButton();

        UserDTO getUserDTO();

        boolean isValid();
    }
}