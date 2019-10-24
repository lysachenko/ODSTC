package com.netcracker.tc.client.ui.presenter.hr;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.widget.hr.MailAsyncTableWidget;

public class MailListView extends com.gwtplatform.mvp.client.ViewImpl implements MailListPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, MailListView> {
    }

    @UiField
    MailAsyncTableWidget mailTable;


//    @UiField
//    Button deleteUserButton;

    @Inject
    MailListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public MailAsyncTableWidget getMailTable() {
        return mailTable;
    }



//    @Override
//    public Button getDeleteUserButton() {
//        return deleteUserButton;
//    }
}