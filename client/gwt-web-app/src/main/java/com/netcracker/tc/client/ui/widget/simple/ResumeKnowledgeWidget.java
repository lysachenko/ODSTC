package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeKnowledgeDTO;

import java.util.ArrayList;
import java.util.List;

public class ResumeKnowledgeWidget extends Composite {

    private ResumeKnowledgeTable resumeKnowledgeTable;
    private VerticalPanel verticalPanel;
    private ResumeKnowledgeListBox knowledgeTypesListBox;
    private Button addKnowledgeTypeButton;
    private List<KnowledgeTypeDTO> knowledgeTypes;

    public ResumeKnowledgeWidget() {
        verticalPanel = new VerticalPanel();

        initResumeKnowledgeTable();
        initResumeTypes();

        initWidget(verticalPanel);
    }

    private void initResumeKnowledgeTable() {
        resumeKnowledgeTable = new ResumeKnowledgeTable();

        resumeKnowledgeTable.setResumeKnowledgeDeleteListener(new ResumeKnowledgeDeleteListener() {
            @Override
            public void onDelete(ResumeKnowledgeDTO resumeKnowledgeDTO) {
                refreshKnowledgeTypes();
            }
        });

        verticalPanel.add(resumeKnowledgeTable);
    }

    private void refreshKnowledgeTypes() {
        List<ResumeKnowledgeDTO> currentKnowledges = resumeKnowledgeTable.getValues();
        List<KnowledgeTypeDTO> currentKnowledgeTypes = new ArrayList<KnowledgeTypeDTO>();
        for (ResumeKnowledgeDTO resumeKnowledgeDTO: currentKnowledges){
            currentKnowledgeTypes.add(resumeKnowledgeDTO.getKnowledgeType());
        }

        List<KnowledgeTypeDTO> result = new ArrayList<KnowledgeTypeDTO>();
        for (KnowledgeTypeDTO knowledgeTypeDTO: knowledgeTypes){
            if (!currentKnowledgeTypes.contains(knowledgeTypeDTO)){
                result.add(knowledgeTypeDTO);
            }
        }

        knowledgeTypesListBox.setKnowledgeTypes(result);
    }

    private void initResumeTypes() {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(knowledgeTypesListBox = new ResumeKnowledgeListBox());
        horizontalPanel.add(addKnowledgeTypeButton = new Button("Добавить"));

        addKnowledgeTypeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                KnowledgeTypeDTO knowledge = knowledgeTypesListBox.getSelectedKnowledgeType();

                if (knowledge != null){
                    List<ResumeKnowledgeDTO> values = resumeKnowledgeTable.getValues();
                    values.add(new ResumeKnowledgeDTO(null, knowledge, 1L));
                    resumeKnowledgeTable.setValues(values);
                    knowledgeTypesListBox.removeSelectedItem();
                }
            }
        });

        verticalPanel.add(horizontalPanel);
    }

    public List<ResumeKnowledgeDTO> getResumeKnowledges() {
        return resumeKnowledgeTable.getValues();
    }

    public void setValues(List<ResumeKnowledgeDTO> values) {
        resumeKnowledgeTable.setValues(values);
        refreshKnowledgeTypes();
    }

    public void setKnowledgeTypes(List<KnowledgeTypeDTO> knowledgeTypes) {
        this.knowledgeTypes = knowledgeTypes;
        refreshKnowledgeTypes();
    }

    public void disableFields() {
        resumeKnowledgeTable.disableTable();
        addKnowledgeTypeButton.setVisible(false);
        knowledgeTypesListBox.setVisible(false);
    }
}