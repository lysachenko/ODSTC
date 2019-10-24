/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import javax.inject.Inject;

/**
 *
 * @author anla1215
 */
public class SettingsView extends ViewImpl implements SettingsPresenter.ViewImpl {
    @UiField
    Button openRegistrationButton;
    @UiField
    Button closeRegistrationButton;
    @UiField
    Button updateBeforeRegistrationMessageButton;
    @UiField
    TextArea beforeRegistrationMessageTextArea;
    @UiField
    SpanElement statusSpanElement;
    @Inject
    SettingsView(SettingsView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Button getOpenRegistrationButton() {
        return openRegistrationButton;
    }

    @Override
    public Button getCloseRegistrationButton() {
        return closeRegistrationButton;
    }
    @Override
    public SpanElement getStatusSpanElement() {
        return statusSpanElement;
    }
    @Override
    public TextArea getBeforeRegistrationMessageTextArea() {
        return beforeRegistrationMessageTextArea;
    }
    @Override
    public Button getUpdateBeforeRegistrationMessageButton() {
        return updateBeforeRegistrationMessageButton;
    }

    static abstract interface Binder extends UiBinder<Widget, SettingsView> {
    }
}
