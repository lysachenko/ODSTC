package com.netcracker.tc.client.ui.layout;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarPresenterWidget;

public class FullScreenLayoutPresenter extends Presenter<FullScreenLayoutPresenter.FullScreenLayoutView, FullScreenLayoutPresenter.FullScreenLayoutProxy> {

    @ProxyStandard
    public interface FullScreenLayoutProxy extends Proxy<FullScreenLayoutPresenter> {
    }

    public interface FullScreenLayoutView extends View {
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> CONTENT_SLOT = new GwtEvent.Type<RevealContentHandler<?>>();
    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> HEADER_CENTER_SLOT = new GwtEvent.Type<RevealContentHandler<?>>();
    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> HEADER_RIGHT_SLOT = new GwtEvent.Type<RevealContentHandler<?>>();

    @Inject
    private NavigationBarPresenterWidget navigationBarPresenterWidget;
    @Inject
    private LoginLogoutPresenterWidget loginLogoutPresenterWidget;

    @Inject
    public FullScreenLayoutPresenter(EventBus eventBus, FullScreenLayoutView view, FullScreenLayoutProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(HEADER_CENTER_SLOT, navigationBarPresenterWidget);
        setInSlot(HEADER_RIGHT_SLOT, loginLogoutPresenterWidget);
    }
}
