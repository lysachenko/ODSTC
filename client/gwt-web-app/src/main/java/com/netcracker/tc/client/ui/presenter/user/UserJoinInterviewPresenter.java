package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.shared.action.interview.*;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.List;

public class UserJoinInterviewPresenter extends Presenter<UserJoinInterviewPresenter.ViewImpl, UserJoinInterviewPresenter.Proxy> {

    @Inject
    private DispatchAsync dispatcher;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private PlaceManager placeManager;

    public interface ViewImpl extends View {

        Button getJoinInterviewButton();

        void setAvailableInterviews(List<AvailableInterviewDTO> availableInterviewDTOList);

        void setIsExistUserInterview(boolean isExistUserInterview);

        InterviewSlotDTO getSelectedInterview();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.ENTRY_FOR_INTERVIEW)
    public interface Proxy extends ProxyPlace<UserJoinInterviewPresenter> {
    }

    @Inject
    public UserJoinInterviewPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    @Override
    protected void onBind() {
        getView().getJoinInterviewButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dispatcher.execute(new AcceptInterviewAction(getView().getSelectedInterview()), new DefaultAsyncCallback<NoResult>() {
                    @Override
                    public void onSuccess(NoResult result) {
                        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.INTERVIEW).build());
                    }
                });
            }
        });
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }

    @Override
    protected void onReset() {
        dispatcher.execute(new GetUserInterviewAction(), new DefaultAsyncCallback<GetUserInterviewResult>() {

            @Override
            public void onSuccess(GetUserInterviewResult result) {
                getView().setIsExistUserInterview(result.getInterviewSlot() != null);
            }
        });

        dispatcher.execute(new GetAvailableInterviewAction(currentUser.getPosition()), new DefaultAsyncCallback<GetAvailableInterviewResult>() {
            @Override
            public void onSuccess(GetAvailableInterviewResult result) {
                getView().setAvailableInterviews(result.getAvailableInterviewDTOList());
            }
        });
    }
}