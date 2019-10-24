/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.GatekeeperParams;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.netcracker.tc.client.application.LoggedInGatekeeper;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.ui.layout.FullScreenLayoutPresenter;
import com.netcracker.tc.client.ui.widget.dialog.AlertDialogPresenter;
import com.netcracker.tc.shared.action.*;
import com.netcracker.tc.shared.model.user.RoleDTO;

/**
 *
 * @author anla1215
 */
public class SettingsPresenter extends Presenter<SettingsPresenter.ViewImpl, SettingsPresenter.Proxy> {
    
    private final DispatchAsync dispatcher;
    
    @Inject
    private AlertDialogPresenter alertDialogPresenter;

    @Inject
    public SettingsPresenter(EventBus eventBus, SettingsPresenter.ViewImpl view, SettingsPresenter.Proxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, FullScreenLayoutPresenter.CONTENT_SLOT, this);
    }
    
    
    @Override
    protected void onBind() {
        
        getView().getOpenRegistrationButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dispatcher.execute(new ChangeRegistrationStatusAction(true), new DefaultAsyncCallback<ChangeRegistrationStatusResult>() {
                    @Override
                    public void onSuccess(ChangeRegistrationStatusResult result) {
                        if(result.getHasErrors()){
                            alertDialogPresenter.show("Что-то пошло не так...");
                            return;
                        } 
                        if(result.getIsChanged()){
                            getView().getStatusSpanElement().setInnerText("открыт");
                            alertDialogPresenter.show("Статус набора успешно изменен.");                            
                        } else {
                            alertDialogPresenter.show("Статус набора не изменился.");
                        }
                    }                        
                }); 
            }
        });
        getView().getCloseRegistrationButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dispatcher.execute(new ChangeRegistrationStatusAction(false), new DefaultAsyncCallback<ChangeRegistrationStatusResult>() {
                    @Override
                    public void onSuccess(ChangeRegistrationStatusResult result) {
                        if(result.getHasErrors()){
                            alertDialogPresenter.show("Что-то пошло не так...");
                            return;
                        }
                        if(result.getIsChanged()){
                            getView().getStatusSpanElement().setInnerText("закрыт");
                            alertDialogPresenter.show("Статус набора успешно изменен.");
                        } else {
                            alertDialogPresenter.show("Статус набора не изменился.");
                        }
                    }
                });
            }
        });
        getView().getUpdateBeforeRegistrationMessageButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dispatcher.execute(new BeforeRegistrationMessageAction(getView().getBeforeRegistrationMessageTextArea().getText()), new DefaultAsyncCallback<BeforeRegistrationMessageResult>() {
                    @Override
                    public void onSuccess(BeforeRegistrationMessageResult result) {


                    }
                });
            }
        });
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        final SpanElement statusSE = getView().getStatusSpanElement();
        dispatcher.execute(new CheckRegistrationStatusAction(), new DefaultAsyncCallback<CheckRegistrationStatusResult>() {
                        @Override
                        public void onSuccess(CheckRegistrationStatusResult result) {
                            if(result.getStatus().booleanValue()){
                                statusSE.setInnerText("opened");
                            } else {
                                statusSE.setInnerText("closed");
                            }
                        }
                    });
        final TextArea beforeRegistrationMessageTextArea = getView().getBeforeRegistrationMessageTextArea();
        dispatcher.execute(new BeforeRegistrationMessageAction(), new DefaultAsyncCallback<BeforeRegistrationMessageResult>() {
            @Override
            public void onSuccess(BeforeRegistrationMessageResult result) {
                beforeRegistrationMessageTextArea.setText(result.getMessage());


            }
        });
    } 
    
    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams({RoleDTO.ROLE_HR})
    @NameToken(NameTokens.Hr.SETTINGS)
    public interface Proxy extends ProxyPlace<SettingsPresenter> {
    }
    
    public interface ViewImpl extends View {
        Button getOpenRegistrationButton();
        Button getCloseRegistrationButton();
        SpanElement getStatusSpanElement();
        Button getUpdateBeforeRegistrationMessageButton();
        TextArea getBeforeRegistrationMessageTextArea();
    }
    
}
