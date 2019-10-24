package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class UserResumeView extends com.gwtplatform.mvp.client.ViewImpl implements UserResumePresenter.ViewImpl {

    @UiField
    Button saveButton;
    @UiField
    Button printButton;
    @UiField
    HTMLPanel resumeWidget;

    interface Binder extends UiBinder<Widget, UserResumeView> {
    }

    @Inject
    UserResumeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setResumeWidget(Widget widget) {
        resumeWidget.clear();
        resumeWidget.add(widget);
    }

    @Override
    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    public Button getPrintButton() {
        return printButton;
    }
}