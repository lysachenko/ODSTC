package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.widget.hr.DevUserInterviewResultWidget;
import com.netcracker.tc.client.ui.widget.hr.QAUserInterviewResultWidget;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.client.ui.widget.resume.QAResumeWidget;
import com.netcracker.tc.client.ui.widget.user.UserFilterWidget;
import com.netcracker.tc.client.ui.widget.user.UserTableWidget;

public class HRUserInterviewListView extends com.gwtplatform.mvp.client.ViewImpl implements HRUserInterviewListPresenter.ViewImpl {

    private static final int DEV_VIEW = 0;
    private static final int QA_VIEW = 1;

    @UiField
    DeckPanel resumeDeckPanel;
    @UiField
    DeckPanel interviewDeckPanel;

    @UiField
    UserTableWidget userTableWidget;
    @UiField
    UserFilterWidget userFilterWidget;
    @UiField
    DevResumeWidget devResumeWidget;
//    @UiField
//    QAResumeWidget qaResumeWidget;
    @UiField
    DevUserInterviewResultWidget devUserInterviewResultWidget;
    @UiField
    QAUserInterviewResultWidget qaUserInterviewResultWidget;

    @UiField
    Button rejectButton;
    @UiField
    Button moveToDateButton;
    @UiField
    Button printResumeButton;

//    @UiField
    SpanElement userStatusSpan;

    @Inject
    HRUserInterviewListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

    }

    @Override
    public Button getMoveToDateButton() {
        return moveToDateButton;
    }
    @Override
    public Button getRejectButton() {
        return rejectButton;
    }

    @Override
    public Button getPrintResumeButton() {
        return printResumeButton;
    }

    @Override
    public UserTableWidget getUserTableWidget() {
        return userTableWidget;
    }

    @Override
    public UserFilterWidget getUserFilterWidget() {
        return userFilterWidget;
    }

    interface Binder extends UiBinder<Widget, HRUserInterviewListView> {

    }
    @Override
    public DevResumeWidget getDevResumeWidget() {
        return devResumeWidget;
    }

    @Override
    public DevUserInterviewResultWidget getDevUserInterviewResultWidget() {
        return devUserInterviewResultWidget;
    }

    @Override
    public QAUserInterviewResultWidget getQaUserInterviewResultWidget() {
        return qaUserInterviewResultWidget;
    }
    @Override
    public SpanElement getUserStatusSpan() {
        return userStatusSpan;
    }
    @Override
    public void setUserStatusSpan(SpanElement userStatusSpan) {
        this.userStatusSpan = userStatusSpan;
    }

//    @Override
//    public QAResumeWidget getQAResumeWidget() {
//        return qaResumeWidget;
//    }

    @Override
    public void showDevViews(boolean devViews) {
        if (devViews){
            resumeDeckPanel.showWidget(DEV_VIEW);
            interviewDeckPanel.showWidget(DEV_VIEW);
        } else {
            resumeDeckPanel.showWidget(QA_VIEW);
            interviewDeckPanel.showWidget(QA_VIEW);
        }
    }
}