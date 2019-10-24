package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.validation.client.impl.metadata.MessageAndPath;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.inject.Inject;
import com.netcracker.tc.client.ui.model.interview.AvailableInterviewTreeModel;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

import java.util.List;

public class UserVerificationCVView extends com.gwtplatform.mvp.client.ViewImpl implements UserVerificationCVPresenter.ViewImpl {

    interface Binder extends UiBinder<Widget, UserVerificationCVView> {
    }

    private static String MESSAGE = "<center><h4>Ваша анкета находится на рассмотрении " +
            "у HR специалистов. <br> Ожидайте результата. </h4>\n </center>";

    @Override
    public void setMessage(String message) {

        messageHTML.setHTML(message);
    }

    @Override
    public void updateMessage() {
        setMessage(MESSAGE);
    }

    @Inject
    UserVerificationCVView(UserVerificationCVView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }


    @UiField
    HTML messageHTML;


}