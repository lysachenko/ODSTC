package com.netcracker.tc.client.ui.widget.authorization;

import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.client.ui.widget.resume.UploadPhotoWidget;
import com.netcracker.tc.client.ui.widget.simple.CheckListBox;
import com.netcracker.tc.client.ui.widget.simple.InstituteListBox;
import com.netcracker.tc.client.ui.widget.simple.ResumeKnowledgeWidget;
import com.netcracker.tc.client.ui.widget.simple.SkillLevelListBox;
import com.netcracker.tc.client.validation.ValidationFactory;
import com.netcracker.tc.shared.action.LoginAction;
import com.netcracker.tc.shared.action.LoginResult;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserStatusDTO;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * Created by unconsionable on 09.07.2014.
 */
public class AuthorizationWidget extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);

    public TextBox getLoginField() {
        return loginField;
    }

    public PasswordTextBox getPasswordField() {
        return passwordField;
    }

    @UiField
    TextBox loginField;
    @UiField
    PasswordTextBox passwordField;

    public AlertBlock getErrorMessageAlertBlock() {
        return errorMessageAlertBlock;
    }


    @UiField
    AlertBlock errorMessageAlertBlock;
    @UiField
    ControlGroup loginGroup;
    @UiField
    ControlGroup passwordGroup;
//    @UiField
//    Button authorizationButton;
    Button cancelButton;


    public AuthorizationWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

//    public Button getAuthorizationButton() {
//        return authorizationButton;
//    }

    interface Binder extends UiBinder<Widget, AuthorizationWidget> {


    }
}