package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
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
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.shared.action.interview.*;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

public class UserVerificationCVPresenter extends Presenter<UserVerificationCVPresenter.ViewImpl, UserVerificationCVPresenter.Proxy> {

    public interface ViewImpl extends View {
        void updateMessage();

        void setMessage(String message);

        HTMLPanel getResumePanel();

        DevResumeWidget getDevResumeWidget();

        void setResumePanel(Widget widget);

        Button getEditResumeButton();

        Button getSubmitResumeButton();
    }

    @Inject
    private DevResumeWidget devResumeWidget;

    @Inject
    public UserVerificationCVPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy
    ) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        super.onBind();

        getView().getEditResumeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO: edit resume
            }
        });

        getView().getSubmitResumeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //TODO: submit resume
            }
        });
    }

    @Override
    protected void onReset() {
        super.onReset();
        getView().updateMessage();
        getView().setResumePanel(devResumeWidget);
        getView().getDevResumeWidget().disableFields();
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_VERIFICATION_CV)
    public interface Proxy extends ProxyPlace<UserVerificationCVPresenter> {
    }
}
