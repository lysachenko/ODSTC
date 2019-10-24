package com.netcracker.tc.client.ui.presenter.hr;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
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
import com.netcracker.tc.client.ui.layout.FullScreenLayoutPresenter;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class InterviewResultListPresenter extends Presenter<InterviewResultListPresenter.ViewImpl, InterviewResultListPresenter.Proxy> {

    @Inject
    public InterviewResultListPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, FullScreenLayoutPresenter.CONTENT_SLOT, this);
    }

    public interface ViewImpl extends View {
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_HR})
    @NameToken(NameTokens.Hr.INTERVIEW_RESULT)
    public interface Proxy extends ProxyPlace<InterviewResultListPresenter> {
    }
}
