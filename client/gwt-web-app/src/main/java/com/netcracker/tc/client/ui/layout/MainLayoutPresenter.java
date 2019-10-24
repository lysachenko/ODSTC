package com.netcracker.tc.client.ui.layout;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.ui.presenter.header.HeaderPresenter;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarPresenterWidget;

/**
 *
 * @author unconsionable
 */
public class MainLayoutPresenter extends Presenter<MainLayoutPresenter.MainLayoutView, MainLayoutPresenter.MainLayoutProxy> {

    @Inject
    private PlaceManager placeManager;

    @ProxyStandard
    public interface MainLayoutProxy extends Proxy<MainLayoutPresenter> {
    }

    public interface MainLayoutView extends View {

        Image getNcLogoImage();
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> CONTENT_SLOT = new Type<RevealContentHandler<?>>();
    @ContentSlot
    public static final Type<RevealContentHandler<?>> HEADER_CENTER_SLOT = new Type<RevealContentHandler<?>>();
    @ContentSlot
    public static final Type<RevealContentHandler<?>> HEADER_RIGHT_SLOT = new Type<RevealContentHandler<?>>();

    @Inject
    private NavigationBarPresenterWidget navigationBarPresenterWidget;
    @Inject
    private LoginLogoutPresenterWidget loginLogoutPresenterWidget;

    @Inject
    public MainLayoutPresenter(EventBus eventBus, MainLayoutView view, MainLayoutProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(HEADER_CENTER_SLOT, navigationBarPresenterWidget);
        setInSlot(HEADER_RIGHT_SLOT, loginLogoutPresenterWidget);

        getView().getNcLogoImage().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.HOME).build());
            }
        });
    }
}