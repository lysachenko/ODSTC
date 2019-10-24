package com.netcracker.tc.client.ui.widget.navigation;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.base.NavbarButton;
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Label;

public class LoginNavigationWidget extends Composite {

    private Button signInButton;
    private Button registrationButton;

    public LoginNavigationWidget(){
        HorizontalPanel horizontalPanel = new HorizontalPanel();

        horizontalPanel.add(signInButton = new Button("Вход"));
        horizontalPanel.add(registrationButton = new Button("Регистрация"));
        horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);

        signInButton.setType(ButtonType.LINK);
        registrationButton.setType(ButtonType.LINK);

        initWidget(horizontalPanel);
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public Button getRegistrationButton() {
        return registrationButton;
    }
}