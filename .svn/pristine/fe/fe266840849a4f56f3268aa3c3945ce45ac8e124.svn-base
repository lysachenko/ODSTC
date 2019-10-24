package com.netcracker.tc.client.ui.presenter.authorization;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.netcracker.tc.client.ui.widget.common.DialogView;
import com.netcracker.tc.client.validation.Registration;
import com.netcracker.tc.client.validation.ValidationFactory;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author unconsionable
 */
public class AuthorizationView extends DialogView implements AuthorizationPresenter.AuthorizationView {

    interface Binder extends UiBinder<Widget, AuthorizationView> {
    }

    @UiField
    TextBox loginField;
    @UiField
    PasswordTextBox passwordField;
    @UiField
    AlertBlock errorMessageAlertBlock;
    @UiField
    ControlGroup loginGroup;
    @UiField
    ControlGroup passwordGroup;

    Button authorizationButton;
    Button cancelButton;

    @Inject
    AuthorizationView(Binder uiBinder, EventBus eventBus) {
        super(eventBus);

        modal.setWidth("315px");
        modal.setTitle("Войти");
        modal.add(uiBinder.createAndBindUi(this));
        ModalFooter modalFooter = new ModalFooter();
        modalFooter.add(authorizationButton = new Button("Войти"));
        modalFooter.add(cancelButton = new Button("Отмена"));
        authorizationButton.setType(ButtonType.INFO);
        cancelButton.setType(ButtonType.INFO);
        modal.add(modalFooter);
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getAuthorizationButton() {
        return authorizationButton;
    }

    public PasswordTextBox getPasswordField() {
        return passwordField;
    }

    public TextBox getLoginField() {
        return loginField;
    }

    public AlertBlock getErrorMessageAlertBlock() {
        return errorMessageAlertBlock;
    }

    @Override
    public boolean isValid() {
        if (loginField.getText().isEmpty() || passwordField.getText().isEmpty()){
            showErrorMessage("Неверный логин или пароль");
            return false;
        }

        hideErrorMessage();

        return true;
    }

    @Override
    public void showErrorMessage(String message) {
        errorMessageAlertBlock.setText(message);
        errorMessageAlertBlock.setVisible(true);
    }

    @Override
    public void hideErrorMessage() {
        errorMessageAlertBlock.setVisible(false);
    }


}