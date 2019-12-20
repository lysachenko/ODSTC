package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.validation.client.impl.metadata.MessageAndPath;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.model.interview.AvailableInterviewTreeModel;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

import java.util.List;

public class UserVerificationCVView extends com.gwtplatform.mvp.client.ViewImpl implements UserVerificationCVPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserVerificationCVView> {
    }

    @UiField
    HTML messageHTML;

    @UiField
    HTMLPanel resumePanel;

    @UiField
    Button editResumeButton;
    @UiField
    Button submitResumeButton;

    private static String MESSAGE = "<center><h4>Ваша анкета находится на рассмотрении " +
            "у HR специалистов. <br> Ожидайте результата. </h4>\n </center>";

    @Inject
    UserVerificationCVView(UserVerificationCVView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void updateMessage() {
        setMessage(MESSAGE);
    }

    @Override
    public void setMessage(String message) {
        messageHTML.setHTML(message);
    }

    @Override
    public HTMLPanel getResumePanel() {
        return resumePanel;
    }

    @Override
    public DevResumeWidget getDevResumeWidget() {
        return (DevResumeWidget) resumePanel.getWidget(0);
    }

    @Override
    public void setResumePanel(Widget widget) {
        resumePanel.clear();
        resumePanel.add(widget);
    }

    @Override
    public Button getEditResumeButton() {
        return editResumeButton;
    }

    @Override
    public Button getSubmitResumeButton() {
        return submitResumeButton;
    }
}