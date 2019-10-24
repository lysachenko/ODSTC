package com.netcracker.tc.client.ui.presenter.authorization;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.annotations.Title;
import com.netcracker.tc.client.ui.widget.common.DialogView;
import com.netcracker.tc.client.validation.ValidationFactory;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.model.user.UserDTO;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class RegistrationView extends DialogView implements RegistrationPresenter.RegistrationView {

    private static final int REGISTRATION_STEP1_VIEW = 0;
    private static final int REGISTRATION_STEP2_VIEW = 1;
    private static final int REGISTRATION_STEP3_VIEW = 2;
    @UiField
    DeckPanel registrationDockPanel;
    @UiField
    TextBox loginField;
    @UiField
    PasswordTextBox passwordField;
    @UiField
    PasswordTextBox confirmPasswordField;
    @UiField
    TextBox captchaField;
    @UiField
    TextBox emailCodeField;
    @UiField
    Button refreshCaptchaButton;
    @UiField
    AlertBlock errorMessageAlertBlock1;
    @UiField
    AlertBlock errorMessageAlertBlock2;
    @UiField
    Image captchaImage;
    @UiField
    ControlGroup loginGroup;
    @UiField
    ControlGroup passwordGroup;
    @UiField
    ControlGroup passwordGroup2;

    Button step1Button;
    Button step2Button;
    Button backButton;
    Button registrationCompleteButton;

    private int version = 0;
    private ModalFooter modalFooter;

    @Inject
    public RegistrationView(Binder binder, EventBus eventBus) {
        super(eventBus);

        modal.setWidth("325px");
        modal.setTitle("Регистрация");
        modal.add(binder.createAndBindUi(this));

        registrationDockPanel.setAnimationEnabled(true);

        modalFooter = new ModalFooter();
        modalFooter.add(step1Button = new Button("Далее"));
        modalFooter.add(backButton = new Button("Назад"));
        modalFooter.add(step2Button = new Button("Регистрация"));
        modalFooter.add(registrationCompleteButton = new Button("Ок"));

        modal.add(modalFooter);

        step1Button.setType(ButtonType.INFO);
        step2Button.setType(ButtonType.INFO);
        registrationCompleteButton.setType(ButtonType.SUCCESS);

        backButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                showStep1View();
            }
        });

        refreshCaptchaButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                refreshCaptcha();
            }
        });
    }

    @Override
    public TextBox getLoginField() {
        return loginField;
    }

    @Override
    public PasswordTextBox getPasswordField() {
        return passwordField;
    }

    @Override
    public PasswordTextBox getConfirmPasswordField() {
        return confirmPasswordField;
    }

    @Override
    public Button getStep1Button() {
        return step1Button;
    }

    @Override
    public Button getStep2Button() {
        return step2Button;
    }

    @Override
    public TextBox getCaptchaField() {
        return captchaField;
    }

    @Override
    public TextBox getEmailCodeField() {
        return emailCodeField;
    }

    @Override
    public void refreshCaptcha() {
        version++;
        //seva0116
        captchaImage.setUrl(GWT.getHostPageBaseURL() + "SimpleCaptcha.jpg?version=" + version);
    }

    @Override
    public boolean isValid() {
        if (!getPasswordField().getText().equals(getConfirmPasswordField().getText())) {
            showErrorMessage("Пароли не совпадают");
            return false;
        } else {
            hideErrorMessage();
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(loginField.getText());
        userDTO.setPassword(passwordField.getText());
        Set<ConstraintViolation<UserDTO>> violations = ValidationFactory.validate(userDTO);
        loginGroup.setStyleName("control-group none");
        passwordGroup.setStyleName("control-group none");
        if (violations.isEmpty()) {
            return true;
        } else {
            for (ConstraintViolation violation : violations) {
                com.google.gwt.core.shared.GWT.log(violation.getPropertyPath() + " ");
                if (violation.getPropertyPath().toString().equals("login")) {
                    loginGroup.setStyleName("control-group error");
                }
                if (violation.getPropertyPath().toString().equals("password")) {
                    passwordGroup.setStyleName("control-group error");
                }
            }
            showErrorMessage("Неверный логин или пароль");
            return false;
        }
    }

    @Override
    public void showStep1View() {
        registrationDockPanel.showWidget(REGISTRATION_STEP1_VIEW);
        step1Button.setVisible(true);
        backButton.setVisible(false);
        step2Button.setVisible(false);
        registrationCompleteButton.setVisible(false);
    }

    @Override
    public void showStep2View() {
        registrationDockPanel.showWidget(REGISTRATION_STEP2_VIEW);
        step1Button.setVisible(false);
        backButton.setVisible(true);
        step2Button.setVisible(true);
        registrationCompleteButton.setVisible(false);
    }

    @Override
    public void showStep3View() {
        registrationDockPanel.showWidget(REGISTRATION_STEP3_VIEW);
        step1Button.setVisible(false);
        backButton.setVisible(false);
        step2Button.setVisible(false);
        registrationCompleteButton.setVisible(true);
    }

    @Override
    public void showErrorMessage(String message) {
        if (registrationDockPanel.getVisibleWidget() == REGISTRATION_STEP1_VIEW) {
            errorMessageAlertBlock1.setText(message);
            errorMessageAlertBlock1.setVisible(true);
        } else {
            errorMessageAlertBlock2.setText(message);
            errorMessageAlertBlock2.setVisible(true);
        }
    }

    @Override
    public void hideErrorMessage() {
        if (registrationDockPanel.getVisibleWidget() == REGISTRATION_STEP1_VIEW) {
            errorMessageAlertBlock1.setVisible(false);
        } else {
            errorMessageAlertBlock2.setVisible(false);
        }
    }

    @Override
    public Button getRegistrationCompleteButton() {
        return registrationCompleteButton;
    }

    interface Binder extends UiBinder<Widget, RegistrationView> {
    }
}