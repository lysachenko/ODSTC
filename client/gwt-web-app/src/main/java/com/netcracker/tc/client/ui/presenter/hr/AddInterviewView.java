package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.netcracker.tc.client.ui.model.Constants;
import com.netcracker.tc.client.ui.widget.simple.TimeBox;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import com.netcracker.tc.shared.model.user.PositionDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class AddInterviewView extends PopupViewImpl implements AddInterviewPresenter.AddInterviewView {

    @UiField
    DateBox startDateTime;
    @UiField
    TimeBox startTimeBox;
    @UiField
    TimeBox endTimeBox;
    @UiField
    IntegerBox interviewerCountField;
    @UiField
    IntegerBox interviewerTimeField;
    @UiField
    IntegerBox hrCountField;
    @UiField
    IntegerBox hrTimeField;
    @UiField
    ListBox positionListBox;
    @UiField
    ListBox activateInterviewListBox;
    @UiField
    IntegerBox totalPlaceCountField;

    @UiField
    Button saveButton;
    @UiField
    Button cancelButton;

    @Inject
    public AddInterviewView(AddInterviewView.Binder binder, EventBus eventBus) {
        super(eventBus);

        initWidget(binder.createAndBindUi(this));
        startDateTime.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(Constants.DATE_FORMAT)));

        final ValueChangeHandler<Integer> updateTotalPlaceCountHandler = new ValueChangeHandler<Integer>() {

            @Override
            public void onValueChange(ValueChangeEvent<Integer> event) {
                updateTotalPlaceCount();
            }
        };

        ChangeHandler changeHandler = new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                updateTotalPlaceCount();
            }
        };

        startTimeBox.addChangeChandler(changeHandler);
        endTimeBox.addChangeChandler(changeHandler);

        interviewerCountField.addValueChangeHandler(updateTotalPlaceCountHandler);
        hrCountField.addValueChangeHandler(updateTotalPlaceCountHandler);
        interviewerTimeField.addValueChangeHandler(updateTotalPlaceCountHandler);
        hrTimeField.addValueChangeHandler(updateTotalPlaceCountHandler);
    }

    private void updateTotalPlaceCount() {
        Integer interviewerCount = interviewerCountField.getValue();
        Integer hrCount = hrCountField.getValue();
        Integer interviewerTime = interviewerTimeField.getValue();
        Integer hrTime = hrTimeField.getValue();
        long startTime = startTimeBox.getValue();
        long endTime = endTimeBox.getValue();

        if (interviewerCount == null || hrCount == null || interviewerTime == null || hrTime == null || startTime > endTime || interviewerCount <= 0 || hrCount <= 0 || interviewerTime <= 0 || hrTime <= 0) {
            totalPlaceCountField.setText("");
            return;
        }

        long hrTimeForOne = hrTime / hrCount;
        long interviewerTimeForOne = interviewerTime / interviewerCount;

        long timeForOne = Math.max(hrTimeForOne, interviewerTimeForOne);

        long totalPlaceCount = (endTime - startTime) / 60 / 1000 / timeForOne;
        totalPlaceCountField.setText(String.valueOf(totalPlaceCount));
    }

    @Override
    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    public Button getCancelButton() {
        return cancelButton;
    }

    @Override
    public InterviewDTO getInterview() {
        InterviewDTO interview = new InterviewDTO();

        interview.setPosition(positionListBox.getSelectedIndex() == 0 ? new PositionDTO(2L, "Dev") : new PositionDTO(1L, "QA"));
        interview.setInterviewDate(startDateTime.getValue());
        interview.setStartTime(startTimeBox.getValue());
        interview.setEndTime(endTimeBox.getValue());
        interview.setHrCount(Integer.valueOf(hrCountField.getText()));
        interview.setInterviewerCount(Integer.valueOf(interviewerCountField.getText()));
        interview.setEnable(activateInterviewListBox.getSelectedIndex() == 0 ? false : true);
        interview.setHrTimeForInterview(hrTimeField.getValue());
        interview.setInterviewerTimeForInterview(interviewerTimeField.getValue());

        return interview;
    }

    interface Binder extends UiBinder<Widget, AddInterviewView> {
    }
}
