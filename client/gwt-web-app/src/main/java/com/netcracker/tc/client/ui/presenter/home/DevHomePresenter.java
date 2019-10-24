package com.netcracker.tc.client.ui.presenter.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;

public class DevHomePresenter extends Presenter<DevHomePresenter.MyView, DevHomePresenter.MyProxy> {

    @Inject
    public DevHomePresenter(MyProxy proxy, EventBus eventBus, MyView view) {
        super(eventBus, view, proxy);
    }

    protected void onHide() {
    }

    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME_DEV)
    public interface MyProxy extends ProxyPlace<DevHomePresenter> {
    }

    public interface MyView extends View {
    }
}
