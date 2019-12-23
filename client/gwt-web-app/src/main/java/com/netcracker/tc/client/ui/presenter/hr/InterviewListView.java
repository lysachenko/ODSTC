package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.netcracker.tc.client.ui.widget.interview.InterviewAsyncTableWidget;

import javax.inject.Inject;

public class InterviewListView extends ViewImpl implements InterviewListPresenter.ViewImpl {
    @UiField
    InterviewAsyncTableWidget interviewTable;
    @UiField
    Button deleteInterviewButton;
    @UiField
    Button addInterviewButton;
    @UiField
    Button startRegistrationButton;
    @UiField
    Button stopRegistrationButton;
    @UiField
    Button getInterviewResultsButton;
    @UiField
    Button getDetailInfoButton;

    @Inject
    InterviewListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public InterviewAsyncTableWidget getInterviewTable() {
        return this.interviewTable;
    }

    public Button getDeleteInterviewButton() {
        return deleteInterviewButton;
    }

    public Button getAddInterviewButton() {
        return this.addInterviewButton;
    }

    public Button getStartRegistrationButton() {
        return this.startRegistrationButton;
    }

    public Button getStopRegistrationButton() {
        return this.stopRegistrationButton;
    }

    public Button getGetInterviewResultsButton() {
        return this.getInterviewResultsButton;
    }

    public Button getDetailInfoButton() { return this.getDetailInfoButton; }

    static abstract interface Binder extends UiBinder<Widget, InterviewListView> {
    }
}
