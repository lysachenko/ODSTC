package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ListBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckListBox extends ListBox {

    protected List<String> values;

    public CheckListBox(){
        values = Arrays.asList("?", "-", "±", "+");
        resetListValues();
    }

    public void setValues(String values){
        this.values = new ArrayList<String>();
        for (String value: values.split(",")){
            this.values.add(value);
        }

        resetListValues();
    }

    private void resetListValues() {
        clear();
        for (String value: values){
            addItem(value);
        }
    }

    public String getSelectedValue(){
        return getValue();
    }

    public void setSelectedValue(String value){
        int index = values.indexOf(value);

        setSelectedIndex(index);
    }
}
