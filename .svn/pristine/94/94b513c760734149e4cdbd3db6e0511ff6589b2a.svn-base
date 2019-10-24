package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.widget.user.UserAsyncTableWidget;

public class UserListView extends com.gwtplatform.mvp.client.ViewImpl implements UserListPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserListView> {
    }

    @UiField
    UserAsyncTableWidget userTable;

    @UiField
    Button addUserButton;

    @UiField
    Button changePasswordButton;

//    @UiField
//    Button deleteUserButton;

    @Inject
    UserListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public UserAsyncTableWidget getUserTable() {
        return userTable;
    }

    @Override
    public Button getAddUserButton() {
        return addUserButton;
    }

    @Override
    public Button getChangePasswordButton() {
        return changePasswordButton;
    }

//    @Override
//    public Button getDeleteUserButton() {
//        return deleteUserButton;
//    }
}