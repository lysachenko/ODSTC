package com.netcracker.tc.client.ui.presenter.header;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarPresenterWidget;

public class HeaderPresenter extends Presenter<HeaderPresenter.HeaderView, HeaderPresenter.HeaderProxy> {

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> LEFT_SLOT = new GwtEvent.Type<RevealContentHandler<?>>();
    @Inject
    private NavigationBarPresenterWidget navigationBarPresenterWidget;
    @Inject
    private LoginLogoutPresenterWidget loginLogoutPresenterWidget;

    @Inject
    public HeaderPresenter(EventBus eventBus, HeaderView view, HeaderProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        setInSlot(LEFT_SLOT, navigationBarPresenterWidget);
        getView().setRightMenu(loginLogoutPresenterWidget.asWidget());
    }

    @ProxyStandard
    @NoGatekeeper
    public interface HeaderProxy extends Proxy<HeaderPresenter> {
    }

    public interface HeaderView extends View {

        void setRightMenu(Widget widget);
    }
}