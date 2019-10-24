package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public class RoleListBox extends ListBox {

    private List<RoleDTO> roles;

    public RoleListBox() {
        roles = new ArrayList<RoleDTO>();
        roles.add(new RoleDTO(1, "Студент"));
        roles.add(new RoleDTO(2, "Админ"));
        roles.add(new RoleDTO(3, "Интервьювер"));
        roles.add(new RoleDTO(4, "HR"));

        for (RoleDTO role : roles) {
            addItem(role.getDescription());
        }
    }

    public RoleDTO getSelectedRole() {
        return roles.get(getSelectedIndex());
    }
}