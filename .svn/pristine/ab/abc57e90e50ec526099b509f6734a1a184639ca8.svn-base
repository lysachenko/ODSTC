package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class ChangePasswordView extends PopupViewImpl implements ChangePasswordPresenter.ChangePasswordView{

    @UiField
    PasswordTextBox passwordField;
    @UiField
    PasswordTextBox confirmPasswordField;

    @UiField
    Button saveButton;
    @UiField
    Button cancelButton;

    interface Binder extends UiBinder<Widget, ChangePasswordView> {
    }

    @Inject
    protected ChangePasswordView(Binder binder, EventBus eventBus) {
        super(eventBus);

        initWidget(binder.createAndBindUi(this));
    }

    public PasswordTextBox getPasswordField() {
        return passwordField;
    }

    public PasswordTextBox getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
