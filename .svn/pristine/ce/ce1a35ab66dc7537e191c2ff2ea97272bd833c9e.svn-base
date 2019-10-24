package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.netcracker.tc.client.ui.widget.simple.RoleListBox;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class AddUserView extends PopupViewImpl implements AddUserPresenter.AddUserView {

    @UiField
    TextBox loginField;
    @UiField
    PasswordTextBox passwordField;
    @UiField
    RoleListBox roleListBox;
    @UiField
    PasswordTextBox confirmPasswordField;
    @UiField
    TextBox nameField;
    @UiField
    TextBox surnameField;
    @UiField
    TextBox engNameField;
    @UiField
    TextBox engSurnameField;
    @UiField
    TextBox emailField;
    @UiField
    TextBox telephoneField;
    @UiField
    TextBox skypeField;

    @UiField
    Button saveButton;
    @UiField
    Button cancelButton;

    interface Binder extends UiBinder<Widget, AddUserView> {
    }

    @Inject
    public AddUserView(Binder binder, EventBus eventBus) {
        super(eventBus);

        initWidget(binder.createAndBindUi(this));
    }

    public TextBox getLoginField() {
        return loginField;
    }

    public PasswordTextBox getPasswordField() {
        return passwordField;
    }

    public RoleListBox getRoleListBox() {
        return roleListBox;
    }

    public PasswordTextBox getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public TextBox getNameField() {
        return nameField;
    }

    public TextBox getSurnameField() {
        return surnameField;
    }

    public TextBox getEngNameField() {
        return engNameField;
    }

    public void setEngNameField(TextBox engNameField) {
        this.engNameField = engNameField;
    }

    public TextBox getEngSurnameField() {
        return engSurnameField;
    }

    public void setEngSurnameField(TextBox engSurnameField) {
        this.engSurnameField = engSurnameField;
    }

    public TextBox getEmailField() {
        return emailField;
    }

    public TextBox getTelephoneField() {
        return telephoneField;
    }

    public TextBox getSkypeField() {
        return skypeField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    @Override
    public UserDTO getUserDTO() {
        final UserDTO user = new UserDTO();
        user.setPassword(getPasswordField().getText());
        user.setLogin(getLoginField().getText());
        user.setRole(getRoleListBox().getSelectedRole());

        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setName(getNameField().getText());
        resumeDTO.setSurname(getSurnameField().getText());
        resumeDTO.setEngName(getEngNameField().getText());
        resumeDTO.setEngSurname(getEngSurnameField().getText());
        resumeDTO.setEmail(getEmailField().getText());
        resumeDTO.setSkype(getSkypeField().getText());
        resumeDTO.setTelephoneNum(getTelephoneField().getText());

        user.setResume(resumeDTO);

        return user;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
