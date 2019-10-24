package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.GatekeeperParams;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.LoggedInGatekeeper;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.event.LoginAuthenticatedEvent;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.shared.ServicePath;
import com.netcracker.tc.shared.action.interview.AcceptInterviewAction;
import com.netcracker.tc.shared.action.interview.GetAvailableInterviewAction;
import com.netcracker.tc.shared.action.interview.GetAvailableInterviewResult;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.List;

public class UserVerificationCVPresenter extends Presenter<UserVerificationCVPresenter.ViewImpl, UserVerificationCVPresenter.Proxy> {

    @Inject
    public UserVerificationCVPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
super.onBind();
    }

    @Override
    protected void onReset() {
        super.onReset();
        getView().updateMessage();

}

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }



    public interface ViewImpl extends View {
        void setMessage(String message);

        void updateMessage();

    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_VERIFICATION_CV)
    public interface Proxy extends ProxyPlace<UserVerificationCVPresenter> {
    }
}
