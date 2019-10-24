package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class UserFirstEntryStep1View extends com.gwtplatform.mvp.client.ViewImpl implements UserFirstEntryStep1Presenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserFirstEntryStep1View> {
    }

    @UiField
    Button selectDevButton;

    @UiField
    Button selectQAButton;

    @Inject
    UserFirstEntryStep1View(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Button getSelectDevButton() {
        return selectDevButton;
    }

    @Override
    public Button getSelectQAButton() {
        return selectQAButton;
    }
}