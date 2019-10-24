package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class UserFillingCVView extends com.gwtplatform.mvp.client.ViewImpl implements UserFillingCVPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserFillingCVView> {
    }

    @UiField
    HTMLPanel resumePanel;

    @UiField
    Button nextStepButton;
    @UiField
    Button backStepButton;

    @Inject
    UserFillingCVView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Button getNextStepButton() {
        return nextStepButton;
    }
    @Override
    public Button getBackStepButton() {
        return backStepButton;
    }

    @Override
    public void setResumePanel(Widget widget) {
        resumePanel.clear();
        resumePanel.add(widget);
    }
}
