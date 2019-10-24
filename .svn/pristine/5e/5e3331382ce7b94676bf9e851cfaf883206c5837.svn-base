package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
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
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.netcracker.tc.client.application.LoggedInGatekeeper;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.shared.ServicePath;
import com.netcracker.tc.shared.action.interview.CancelInterviewAction;
import com.netcracker.tc.shared.action.interview.GetUserInterviewAction;
import com.netcracker.tc.shared.action.interview.GetUserInterviewResult;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.Date;

public class UserInterviewPresenter extends Presenter<UserInterviewPresenter.ViewImpl, UserInterviewPresenter.Proxy> {

    @Inject
    private DispatchAsync dispatcher;

    @Inject
    public UserInterviewPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        super.onBind();

        getView().getCancelInterviewButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (Window.confirm("Вы уверены, что хотите отменить собеседование?")) {
                    dispatcher.execute(new CancelInterviewAction(), new DefaultAsyncCallback<NoResult>() {
                        @Override
                        public void onSuccess(NoResult result) {
                            getView().setUserInterview(null, null);
                        }
                    });
                }
            }
        });

        getView().getLoadResumeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ServicePath.DOWNLOAD_SERVLET_PATH, "", "");
            }
        });
    }

    @Override
    protected void onReset() {
        dispatcher.execute(new GetUserInterviewAction(), new DefaultAsyncCallback<GetUserInterviewResult>() {

            @Override
            public void onSuccess(GetUserInterviewResult result) {
                InterviewSlotDTO interviewSlot = result.getInterviewSlot();

                getView().setUserInterview(result.getUserName(), interviewSlot == null ? null : interviewSlot.getInterviewDate());
            }
        });
    }

    @Override
    protected void onHide() {
        super.onHide();
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    public DispatchAsync getDispatcher() {
        return dispatcher;
    }

    public interface ViewImpl extends View {

        void setUserInterview(String name, Date interviewDate);

        Button getLoadResumeButton();

        Button getCancelInterviewButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.INTERVIEW)
    public interface Proxy extends ProxyPlace<UserInterviewPresenter> {
    }
}