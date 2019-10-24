package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.netcracker.tc.client.ui.presenter.home.HomePresenter;
import com.netcracker.tc.client.ui.presenter.home.HomeUiHandlers;

public class QAInformationView extends ViewImpl implements QAInformationPresenter.MyView {

    @UiField
    Button backButton;

    @Inject
    QAInformationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface Binder extends UiBinder<Widget, QAInformationView> {
    }

    @Override
    public Button getBackButton() {
        return backButton;
    }
}