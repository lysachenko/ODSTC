package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;

/**
 * @author unconsionable
 */
public class QAInformationPresenter extends Presenter<QAInformationPresenter.MyView, QAInformationPresenter.MyProxy> {

    @Inject
    private PlaceManager placeManager;

    @Inject
    public QAInformationPresenter(
            final MyProxy proxy,
            final EventBus eventBus,
            final MyView view) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    public interface MyView extends View {

        Button getBackButton();
    }

    @Override
    protected void onBind() {
        getView().getBackButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_POSITION).build());
            }
        });
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.User.QA_PAGE)
    public interface MyProxy extends ProxyPlace<QAInformationPresenter> {
    }
}