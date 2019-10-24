package com.netcracker.tc.client.ui.widget.dialog;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class AlertDialogPresenter extends PresenterWidget<AlertDialogPresenter.View> {

    @Inject
    public AlertDialogPresenter(EventBus eventBus, View view) {
        super(eventBus, view);
    }

    public void show(String errorMessage) {
        getView().showErrorMessage(errorMessage);

        getView().show();
    }

    public interface View extends PopupView {

        void showErrorMessage(String message);
    }
}