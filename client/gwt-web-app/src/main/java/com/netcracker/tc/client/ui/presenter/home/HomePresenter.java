package com.netcracker.tc.client.ui.presenter.home;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;

import com.google.inject.Inject;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;

/**
 * @author unconsionable
 */
public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    @Inject
    private PlaceManager placeManager;

    @Inject
    public HomePresenter(
            final MyProxy proxy,
            final EventBus eventBus,
            final MyView view) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onHide() {

    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    public interface MyView extends View {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }
}