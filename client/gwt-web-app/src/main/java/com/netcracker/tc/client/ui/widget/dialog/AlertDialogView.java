package com.netcracker.tc.client.ui.widget.dialog;

import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ModalFooter;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.netcracker.tc.client.ui.widget.common.DialogView;

public class AlertDialogView extends DialogView implements AlertDialogPresenter.View {

    @UiField
    AlertBlock errorMessageAlertBlock;
    @UiField
    Button okButton;

    @Inject
    public AlertDialogView(Binder binder, EventBus eventBus) {
        super(eventBus);

        modal.setWidth("325px");
        modal.add(binder.createAndBindUi(this));
        modal.addStyleName("modal-alert");

        okButton.setType(ButtonType.WARNING);

        okButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                hide();
            }
        });
    }

    @Override
    public void showErrorMessage(String message) {
        errorMessageAlertBlock.setText(message);
    }

    interface Binder extends UiBinder<Widget, AlertDialogView> {
    }
}
