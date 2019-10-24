package com.netcracker.tc.client.ui.widget.simple;

import com.google.gwt.user.client.ui.ListBox;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;

import java.util.ArrayList;
import java.util.List;

public class ResumeKnowledgeListBox extends ListBox {

    private List<KnowledgeTypeDTO> knowledgeTypes;

    public ResumeKnowledgeListBox() {
        knowledgeTypes = new ArrayList<KnowledgeTypeDTO>();
    }

    public void setKnowledgeTypes(List<KnowledgeTypeDTO> knowledgeTypes) {
        this.knowledgeTypes = knowledgeTypes;
        clear();
        for (KnowledgeTypeDTO knowledgeTypeDTO : knowledgeTypes) {
            addItem(knowledgeTypeDTO.getDescription());
        }
    }

    public KnowledgeTypeDTO getSelectedKnowledgeType(){
        if (getSelectedIndex() != -1){
            return knowledgeTypes.get(getSelectedIndex());
        }

        return null;
    }

    public void removeSelectedItem() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex != -1){
            knowledgeTypes.remove(selectedIndex);
            removeItem(selectedIndex);
        }
    }
}