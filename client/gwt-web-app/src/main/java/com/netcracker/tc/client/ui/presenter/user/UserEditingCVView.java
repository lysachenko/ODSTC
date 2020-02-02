package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;

public class UserEditingCVView extends com.gwtplatform.mvp.client.ViewImpl
        implements UserEditingCVPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserEditingCVView> {
    }

    @UiField
    HTML messageHTML;

    @UiField
    HTMLPanel resumePanel;

    @UiField
    Button cancelChangesButton;
    @UiField
    Button saveChangesButton;

    private static String MESSAGE = "<center><h4>Редактирование анкеты</h4></center>" +
            "<p><i>Тут Вы можете вносить изменения в Вашу анкету." +
            "<br>Для сохранения изменений анкеты в Личном кабинете нажмите \"Сохранить\" внизу страницы.</i></p>" +
            "<p><i><b>Внимание:</b> отправить на проверку конечный вариант анкеты Вы можете только один раз." +
            "</i></p>";;

    @Inject
    UserEditingCVView(UserEditingCVView.Binder uiBinder) {
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
    public DevResumeWidget getDevResumeWidget() {
        return (DevResumeWidget) resumePanel.getWidget(0);
    }

    @Override
    public void setResumePanel(Widget widget) {
        resumePanel.clear();
        resumePanel.add(widget);
    }

    @Override
    public Button getCancelChangesButton() {
        return cancelChangesButton;
    }

    @Override
    public Button getSaveChangesButton() {
        return saveChangesButton;
    }
}