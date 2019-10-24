package com.netcracker.tc.client.ui.widget.interview;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.tc.client.ui.model.Constants;
import com.netcracker.tc.client.ui.widget.common.AbstractAsyncTableWidget;
import com.netcracker.tc.shared.model.interview.InterviewDTO;

import java.util.Date;

/**
 * Created by unconsionable on 23.06.2014.
 */
public class InterviewAsyncTableWidget extends AbstractAsyncTableWidget<InterviewDTO> {

    private DateTimeFormat dateFormat = DateTimeFormat.getFormat(Constants.DATE_FORMAT);
    private DateTimeFormat timeFormat = DateTimeFormat.getFormat(Constants.TIME_FORMAT);

//    @Override
//    protected void initSelectionModel() {
//        selectionModel = new MultiSelectionModel<InterviewDTO>(new ProvidesKey<InterviewDTO>() {
//            @Override
//            public Object getKey(InterviewDTO item) {
//                return item == null ? null : item.getId();
//            }
//        });
//        table.setSelectionModel(selectionModel,
//                DefaultSelectionEventManager.<InterviewDTO> createCheckboxManager());
//    }

    @Override
    protected void initTableColumns() {
//        Column<InterviewDTO, Boolean> checkColumn = new Column<InterviewDTO, Boolean>(
//                new CheckboxCell(true, false)) {
//            @Override
//            public Boolean getValue(InterviewDTO object) {
//                return selectionModel.isSelected(object);
//            }
//        };

        TextColumn<InterviewDTO> interviewDateColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return dateFormat.format(object.getInterviewDate());
            }
        };

        TextColumn<InterviewDTO> interviewTimeColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return timeFormat.format(new Date(object.getInterviewDate().getTime() + object.getStartTime())) + " - "
                        + timeFormat.format(new Date(object.getInterviewDate().getTime() + object.getEndTime()));
            }
        };

        TextColumn<InterviewDTO> totalPlaceCountColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return String.valueOf(object.getTotalPlaceCount());
            }
        };

        TextColumn<InterviewDTO> availablePlaceCountColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return String.valueOf(object.getAvailablePlaceCount());
            }
        };

        TextColumn<InterviewDTO> positionsColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return object.getPosition().getDescription();

            }
        };

        TextColumn<InterviewDTO> isInterviewEnableColumn = new TextColumn<InterviewDTO>() {
            @Override
            public String getValue(InterviewDTO object) {
                return object.getEnable() ? "Да" : "Нет";
            }
        };

//        table.addColumn(checkColumn);
        table.addColumn(interviewDateColumn, "Дата");
        table.addColumn(interviewTimeColumn, "Время");
        table.addColumn(totalPlaceCountColumn, "Всего мест");
        table.addColumn(availablePlaceCountColumn, "Доступно");
        table.addColumn(positionsColumn, "Позиция");
        table.addColumn(isInterviewEnableColumn, "Активирована регистрация");
    }
}