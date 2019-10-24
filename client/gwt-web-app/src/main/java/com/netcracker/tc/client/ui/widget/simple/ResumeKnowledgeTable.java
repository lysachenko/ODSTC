package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.netcracker.tc.client.ui.widget.common.AbstractStaticTableWidget;
import com.netcracker.tc.shared.model.resume.ResumeKnowledgeDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeKnowledgeTable extends AbstractStaticTableWidget<ResumeKnowledgeDTO> {

    private ResumeKnowledgeDeleteListener resumeKnowledgeDeleteListener;

    public ResumeKnowledgeTable(){
    }

    @Override
    protected void initTableColumns() {
        TextColumn<ResumeKnowledgeDTO> knowledgeTypeColumn = new TextColumn<ResumeKnowledgeDTO>() {
            @Override
            public String getValue(ResumeKnowledgeDTO object) {
                return object.getKnowledgeType().getDescription();
            }
        };

        Column<ResumeKnowledgeDTO, String> knowledgeLevelColumn = new Column<ResumeKnowledgeDTO, String>(new SelectionCell(Arrays.asList("1", "2", "3", "4", "5"))) {
            @Override
            public String getValue(ResumeKnowledgeDTO object) {
                return object.getKnowledgeLevel().toString();
            }
        };

        knowledgeLevelColumn.setFieldUpdater(new FieldUpdater<ResumeKnowledgeDTO, String>() {
            @Override
            public void update(int index, ResumeKnowledgeDTO object, String value) {
                object.setKnowledgeLevel(Long.valueOf(value));
            }
        });
        knowledgeLevelColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Column<ResumeKnowledgeDTO, String> removeColumn = new Column<ResumeKnowledgeDTO, String>(new ButtonCell(IconType.REMOVE)) {
            @Override
            public String getValue(ResumeKnowledgeDTO object) {
                return "";
            }
        };
        removeColumn.setFieldUpdater(new FieldUpdater<ResumeKnowledgeDTO, String>() {
            @Override
            public void update(int index, ResumeKnowledgeDTO object, String value) {
                List<ResumeKnowledgeDTO> list = dataProvider.getList();
                list.remove(index);
                setValues(list);

                if (resumeKnowledgeDeleteListener != null){
                    resumeKnowledgeDeleteListener.onDelete(object);
                }
            }
        });


        table.addColumn(knowledgeTypeColumn);
        table.addColumn(knowledgeLevelColumn);
        table.addColumn(removeColumn);
    }

    public List<ResumeKnowledgeDTO> getValues() {
        List<ResumeKnowledgeDTO> resumeKnowledgeDTOs = new ArrayList<ResumeKnowledgeDTO>();
        for (ResumeKnowledgeDTO resumeKnowledgeDTO: dataProvider.getList()){
            resumeKnowledgeDTOs.add(resumeKnowledgeDTO);
        }
        return resumeKnowledgeDTOs;
    }

    public void setResumeKnowledgeDeleteListener(ResumeKnowledgeDeleteListener resumeKnowledgeDeleteListener) {
        this.resumeKnowledgeDeleteListener = resumeKnowledgeDeleteListener;
    }

    public void disableTable(){
        if (table.getColumnCount() > 2) {
            table.removeColumn(2);
            table.removeColumn(1);
        }

        TextColumn<ResumeKnowledgeDTO> knowledgeLevelColumn = new TextColumn<ResumeKnowledgeDTO>() {
            @Override
            public String getValue(ResumeKnowledgeDTO object) {
                return object.getKnowledgeLevel().toString();
            }
        };

        table.addColumn(knowledgeLevelColumn);
    }
}