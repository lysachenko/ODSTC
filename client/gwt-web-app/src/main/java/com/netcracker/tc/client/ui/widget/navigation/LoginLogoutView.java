package com.netcracker.tc.client.ui.widget.navigation;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Created by unconsionable on 21.08.2014.
 */
public class LoginLogoutView extends ViewImpl implements LoginLogoutPresenterWidget.View {

    @UiField
    HTMLPanel menuPanel;

    @Inject
    LoginLogoutView(Binder uiBinder,
                    EventBus eventBus) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setWidget(Widget widget) {
        menuPanel.clear();
        menuPanel.add(widget);
    }

    interface Binder extends UiBinder<Widget, LoginLogoutView> {
    }
}
