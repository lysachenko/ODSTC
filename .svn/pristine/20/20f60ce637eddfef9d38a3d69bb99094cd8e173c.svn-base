package com.netcracker.tc.client.ui.widget.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserStatusDTO;

import java.util.Map;

public class UserFilterWidget extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    TextBox nameTextBox;
    @UiField
    TextBox emailTextBox;
    @UiField
    TextBox telTextBox;
//    @UiField
//    ListBox positionListBox;
    @UiField
    ListBox userStatusListBox;
    @UiField
    Button applyFilter;
    @UiField
    Button resetFilter;

    public UserFilterWidget() {


        initWidget(uiBinder.createAndBindUi(this));
        userStatusListBox.addItem("");
        for(Map.Entry<Long, String> entry: UserStatusDTO.userStatusDesctiprion.entrySet())
             userStatusListBox.addItem(entry.getValue(),String.valueOf(entry.getKey()));


        resetFilter.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                nameTextBox.setText("");
                emailTextBox.setText("");
                telTextBox.setText("");
                userStatusListBox.setSelectedIndex(0);
            }
        });
    }

    public UserPagingFilterDTO getFilter() {
        UserPagingFilterDTO filter = new UserPagingFilterDTO();

        filter.setRoleId(RoleDTO.ROLE_USER_ID);
        filter.setName(nameTextBox.getText());
        filter.setEmail(emailTextBox.getText());
        filter.setTelephone(telTextBox.getText());
//        if (positionListBox.getSelectedIndex() != 0) {
//            filter.setPositionId(Long.valueOf(positionListBox.getSelectedIndex()));
//        }
        if (userStatusListBox.getSelectedIndex() != 0) {
            filter.setUserStatusId(Long.valueOf(userStatusListBox.getValue(userStatusListBox.getSelectedIndex())));
        }


        return filter;
    }

    public Button getApplyFilter() {
        return applyFilter;
    }

    public Button getResetFilter() {
        return resetFilter;
    }

    interface Binder extends UiBinder<Widget, UserFilterWidget> {
    }
}