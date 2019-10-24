package com.netcracker.tc.client.ui.model.interview;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.netcracker.tc.client.ui.model.Constants;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

import java.util.Date;
import java.util.List;

public class AvailableInterviewTreeModel implements TreeViewModel {

    private DateTimeFormat dateFormat = DateTimeFormat.getFormat(Constants.DATE_FORMAT);
    private DateTimeFormat timeFormat = DateTimeFormat.getFormat(Constants.TIME_FORMAT);

    private ListDataProvider<AvailableInterviewDTO> rootDataProvider;

    private SingleSelectionModel<Long> interviewTimeSelectionModel;
    private SingleSelectionModel<AvailableInterviewDTO> availableInterviewSelectionModel;

    public AvailableInterviewTreeModel() {
        rootDataProvider = new ListDataProvider<AvailableInterviewDTO>();
        interviewTimeSelectionModel = new SingleSelectionModel<Long>();
        availableInterviewSelectionModel = new SingleSelectionModel<AvailableInterviewDTO>();
    }

    public <T> NodeInfo<?> getNodeInfo(final T value) {
        if (value == null) {
            // Level 0
            Cell<AvailableInterviewDTO> availableInterviewCell = new AbstractCell<AvailableInterviewDTO>() {

                @Override
                public void render(Context context, AvailableInterviewDTO value, SafeHtmlBuilder sb) {
                    sb.appendHtmlConstant(dateFormat.format(value.getInterview().getInterviewDate()));
                }
            };

            return new DefaultNodeInfo<AvailableInterviewDTO>(rootDataProvider, availableInterviewCell, availableInterviewSelectionModel, null);
        } else if (value instanceof AvailableInterviewDTO) {
            final AvailableInterviewDTO availableInterviewDTO = (AvailableInterviewDTO) value;
            // Level 1
            ListDataProvider<Long> dataProvider = new ListDataProvider<Long>(availableInterviewDTO.getInterviewTimeList());

            Cell<Long> availableTimesCell = new AbstractCell<Long>() {

                @Override
                public void render(Context context, Long time, SafeHtmlBuilder sb) {
                    sb.appendEscaped(timeFormat.format(new Date(availableInterviewDTO.getInterview().getInterviewDate().getTime() + time)));
                }
            };

            return new DefaultNodeInfo<Long>(dataProvider, availableTimesCell, interviewTimeSelectionModel, null);
        }

        return null;
    }

    public void setAvailableInterviewList(List<AvailableInterviewDTO> availableInterviewDTOList) {
        rootDataProvider.setList(availableInterviewDTOList);
        rootDataProvider.refresh();
    }

    public boolean isLeaf(Object value) {
        if (value instanceof Long) {
            return true;
        }

        return false;
    }

    public boolean isInterviewSelected() {
        return availableInterviewSelectionModel.getSelectedObject() != null && interviewTimeSelectionModel.getSelectedObject() != null;
    }

    public InterviewSlotDTO getAvailableInterview() {
        InterviewSlotDTO interviewSlotDTO = new InterviewSlotDTO();
        interviewSlotDTO.setInterview(availableInterviewSelectionModel.getSelectedObject().getInterview());
        interviewSlotDTO.setTime(interviewTimeSelectionModel.getSelectedObject());

        return interviewSlotDTO;
    }

    public SingleSelectionModel<Long> getInterviewTimeSelectionModel() {
        return interviewTimeSelectionModel;
    }
}