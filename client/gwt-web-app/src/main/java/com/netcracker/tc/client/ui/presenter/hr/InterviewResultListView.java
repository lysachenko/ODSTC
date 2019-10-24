package com.netcracker.tc.client.ui.presenter.hr;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class InterviewResultListView extends com.gwtplatform.mvp.client.ViewImpl implements InterviewResultListPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, InterviewResultListView> {
    }

    @Inject
    InterviewResultListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
