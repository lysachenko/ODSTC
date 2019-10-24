package com.netcracker.tc.client.ui.presenter.header;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.client.event.LoginAuthenticatedEventHandler;
import com.netcracker.tc.client.ui.presenter.authorization.AuthorizationPresenter;
import com.netcracker.tc.client.ui.presenter.authorization.RegistrationPresenter;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.LoginNavigationWidget;
import com.netcracker.tc.client.ui.widget.navigation.LogoutNavigationWidget;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarPresenterWidget;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.UserDTO;

public class SimpleHeaderPresenter extends Presenter<SimpleHeaderPresenter.HeaderView, SimpleHeaderPresenter.HeaderProxy> {


    @Inject
    LoginLogoutPresenterWidget loginLogoutPresenterWidget;

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> CENTER_SLOT = new GwtEvent.Type<RevealContentHandler<?>>();

    @Inject
    public SimpleHeaderPresenter(EventBus eventBus, HeaderView view, HeaderProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        getView().setRightMenu(loginLogoutPresenterWidget.asWidget());
    }

    @ProxyStandard
    @NoGatekeeper
    public interface HeaderProxy extends Proxy<SimpleHeaderPresenter> {
    }

    public interface HeaderView extends View {

        void setRightMenu(Widget widget);
    }
}