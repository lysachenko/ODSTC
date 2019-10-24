package com.netcracker.tc.client.ui.presenter.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class QAHomeView extends ViewImpl implements QAHomePresenter.MyView {

    @Inject
    QAHomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface Binder extends UiBinder<Widget, QAHomeView> {
    }
}
