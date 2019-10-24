package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.HelpBlock;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.model.Constants;
import com.netcracker.tc.client.util.FormatUtil;

import java.util.Date;

public class UserInterviewView extends com.gwtplatform.mvp.client.ViewImpl implements UserInterviewPresenter.ViewImpl {

    private static final String MESSAGE = "<p>Вы успешно зарегистрированы на собеседования в Учебный Центр Netcracker!</p>" +
            "<p>Ждём Вас %s в %s по адресу: Одесса, проспект Шевченка, 1, ОНПУ, институт компьютерных систем (корпус № 3), 4-й этаж, ауд. 406, 408, 409.</p>" +
            "<p>Пожалуйста, приходите на собеседования с заранее заполненной и распечатанной анкетой</p>" +
            "<p>Желаем успехов на собеседовании!</p>";

    private static final int EMPTY_USER_INTERVIEW_VIEW = 0;
    private static final int USER_INTERVIEW_VIEW = 1;
    @UiField
    DeckPanel deckPanel;
    @UiField
    Button loadResumeButton;
    @UiField
    Button cancelInterviewButton;
    @UiField
    TextBox interviewDateField;
    @UiField
    HelpBlock timeToInterviewField;
    @UiField
    HTML messageHTML;

    private boolean isVisible = false;

    private DateTimeFormat fullFormat = DateTimeFormat.getFormat(Constants.DATE_TIME_FORMAT);
    private DateTimeFormat dateFormat = DateTimeFormat.getFormat(Constants.DATE_FORMAT);
    private DateTimeFormat timeFormat = DateTimeFormat.getFormat(Constants.TIME_FORMAT);

    @Inject
    UserInterviewView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setUserInterview(String userName, Date interviewDate) {
        if (interviewDate == null) {
            deckPanel.showWidget(EMPTY_USER_INTERVIEW_VIEW);
            return;
        }

        interviewDateField.setText(fullFormat.format(interviewDate));
        String message = "До собеседования осталось " + CalendarUtil.getDaysBetween(new Date(), interviewDate) + " дней";
        timeToInterviewField.setText(message);

        SafeHtml html = new SafeHtml() {
            @Override
            public String asString() {
                return null;
            }
        };
        messageHTML.setHTML(FormatUtil.format(MESSAGE, dateFormat.format(interviewDate).toString(), timeFormat.format(interviewDate).toString()));

        deckPanel.showWidget(USER_INTERVIEW_VIEW);
    }

    @Override
    public Button getLoadResumeButton() {
        return loadResumeButton;
    }

    @Override
    public Button getCancelInterviewButton() {
        return cancelInterviewButton;
    }

    interface Binder extends UiBinder<Widget, UserInterviewView> {
    }
}