package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.model.interview.AvailableInterviewTreeModel;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

import java.util.List;

public class UserRegistrationOnInterviewView extends com.gwtplatform.mvp.client.ViewImpl implements UserRegistrationOnInterviewPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserRegistrationOnInterviewView> {
    }

    private static final int NO_AVAILABLE_INTERVIEW_PANEL = 0;
    private static final int SELECT_INTERVIEW_PANEL = 1;

    private AvailableInterviewTreeModel availableInterviewModel;

    @UiField(provided = true)
    CellBrowser interviewTimeBrowser;

    @UiField
    DeckPanel interviewDockPanel;

    @UiField
    Button joinInterviewButton;

    @UiField
    Button printButton;

    @Inject
    UserRegistrationOnInterviewView(Binder uiBinder) {
        interviewTimeBrowser = new CellBrowser(availableInterviewModel = new AvailableInterviewTreeModel(), null);

        initWidget(uiBinder.createAndBindUi(this));

        availableInterviewModel.getInterviewTimeSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                joinInterviewButton.setEnabled(availableInterviewModel.isInterviewSelected());

            }
        });
    }

    @Override
    public Button getJoinInterviewButton() {
        return joinInterviewButton;
    }

    @Override
    public InterviewSlotDTO getSelectedInterview() {
        return availableInterviewModel.getAvailableInterview();
    }

    @Override
    public void setAvailableInterviews(List<AvailableInterviewDTO> availableInterviewDTOList) {
        interviewDockPanel.showWidget(availableInterviewDTOList.isEmpty() ? NO_AVAILABLE_INTERVIEW_PANEL : SELECT_INTERVIEW_PANEL);
        printButton.setVisible(interviewDockPanel.isVisible());
        availableInterviewModel.setAvailableInterviewList(availableInterviewDTOList);
        joinInterviewButton.setEnabled(false);
    }

    @Override
    public Button getPrintButton() {
        return printButton;
    }
}
