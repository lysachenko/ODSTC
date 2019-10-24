package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ListBox;

public class SkillLevelListBox extends ListBox {

    private int minValue;
    private int maxValue;

    public SkillLevelListBox() {
        minValue = 1;
        maxValue = 5;
        updateListBoxValues();
    }

    private void updateListBoxValues() {
        clear();
        for (int i = minValue; i < maxValue + 1; i++) {
            addItem(String.valueOf(i));
        }
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
        updateListBoxValues();
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        updateListBoxValues();
    }

    public int getSelectedSkill() {
        if (getValue() == null){
            return 0;
        }

        return Integer.valueOf(getValue());
    }

    public void setSelectedSkill(Integer skillLevel) {
        if (skillLevel != null) {
            setSelectedIndex(skillLevel - minValue);
        }
    }
}