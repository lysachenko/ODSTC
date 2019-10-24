package com.netcracker.tc.client.ui.widget.user;

import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.netcracker.tc.client.ui.widget.common.AbstractAsyncTableWidget;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

public class UserTableWidget extends AbstractAsyncTableWidget<UserDTO> {

    @Override
    protected void initTableColumns() {
        TextColumn<UserDTO> nameColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                ResumeDTO resume = object.getResume();
                if (resume != null) {
                    return resume.getSurname() + " " + resume.getName() + " " + resume.getLastName();
                }
                return "";
            }
        };

        TextColumn<UserDTO> emailColumn = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO object) {
                return object.getResume() == null ? "" : object.getResume().getEmail();
            }
        };

        table.addColumn(nameColumn, "Ф.И.О.");
        table.addColumn(emailColumn, "Email");
    }
}