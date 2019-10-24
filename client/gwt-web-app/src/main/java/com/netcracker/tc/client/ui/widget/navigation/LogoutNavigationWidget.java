package com.netcracker.tc.client.ui.widget.navigation;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.NavText;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class LogoutNavigationWidget extends Composite {

    private Button logoutButton;
    private Label userLabel;

    public LogoutNavigationWidget(){
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(userLabel = new Label());
        horizontalPanel.add(logoutButton = new Button("Выйти", IconType.SIGNOUT));
        logoutButton.setType(ButtonType.LINK);

        initWidget((horizontalPanel));
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public Label getUserLabel() {
        return userLabel;
    }
}