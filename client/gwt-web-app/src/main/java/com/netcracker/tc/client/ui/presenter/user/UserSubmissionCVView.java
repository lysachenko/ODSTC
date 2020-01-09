package com.netcracker.tc.client.ui.presenter.user;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;

public class UserSubmissionCVView extends com.gwtplatform.mvp.client.ViewImpl implements UserSubmissionCVPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserSubmissionCVView> {
    }

    @UiField
    HTML messageHTML;

    @UiField
    HTMLPanel resumePanel;

    private static String MESSAGE = "<center><h4>Ваша анкета находится на рассмотрении у HR специалистов." +
            "<br>Ожидайте результата.</h4></center>" +
            "<p><i>Вы отправили конечный вариант анкеты." +
            "</i></p>";

    @Inject
    UserSubmissionCVView(UserSubmissionCVView.Binder uiBinder) {
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

}