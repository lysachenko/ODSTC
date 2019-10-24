package com.netcracker.tc.client.ui.presenter.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class DevHomeView extends ViewImpl implements DevHomePresenter.MyView {

    @Inject
    DevHomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    static abstract interface Binder
            extends UiBinder<Widget, DevHomeView> {
    }
}
