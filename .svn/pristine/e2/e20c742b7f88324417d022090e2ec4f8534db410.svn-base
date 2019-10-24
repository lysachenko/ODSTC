package com.netcracker.tc.client.ui.widget.user;

import com.google.gwt.user.cellview.client.TextColumn;
import com.netcracker.tc.client.ui.widget.common.AbstractAsyncTableWidget;
import com.netcracker.tc.shared.model.user.UserDTO;

public class UserAsyncTableWidget extends AbstractAsyncTableWidget<UserDTO> {

    @Override
    protected void initTableColumns() {
        TextColumn<UserDTO> loginColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getLogin();
            }
        };

        TextColumn<UserDTO> roleColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getRole().getDescription();
            }
        };

        TextColumn<UserDTO> nameColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getName();
            }
        };

        TextColumn<UserDTO> surnameColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getSurname();
            }
        };

        TextColumn<UserDTO> emailColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getEmail();
            }
        };

        TextColumn<UserDTO> telephoneColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getTelephoneNum();
            }
        };

        TextColumn<UserDTO> skypeColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getSkype();
            }
        };

        table.addColumn(loginColumn, "Login");
        table.addColumn(roleColumn, "Roles");
        table.addColumn(nameColumn, "Name");
        table.addColumn(surnameColumn, "Surname");
        table.addColumn(emailColumn, "Email");
        table.addColumn(telephoneColumn, "Telephone");
        table.addColumn(skypeColumn, "Skype");
    }
}