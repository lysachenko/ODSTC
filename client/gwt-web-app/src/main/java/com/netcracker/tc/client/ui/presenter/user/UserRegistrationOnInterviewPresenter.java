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

public class UserRegistrationOnInterviewPresenter extends Presenter<UserRegistrationOnInterviewPresenter.ViewImpl, UserRegistrationOnInterviewPresenter.Proxy> {

    @Inject
    private PlaceManager placeManager;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private DispatchAsync dispatcher;

    @Inject
    public UserRegistrationOnInterviewPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        getView().getJoinInterviewButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                joinInterview();
            }
        });
        getView().getPrintButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ServicePath.DOWNLOAD_SERVLET_PATH, "", "");
            }
        });
    }

    @Override
    protected void onReset() {
        dispatcher.execute(new GetAvailableInterviewAction(currentUser.getPosition()), new DefaultAsyncCallback<GetAvailableInterviewResult>() {

            @Override
            public void onSuccess(GetAvailableInterviewResult result) {
                getView().setAvailableInterviews(result.getAvailableInterviewDTOList());
            }
        });
       /* List<AvailableInterviewDTO> availableInterviewDTOs = new ArrayList<AvailableInterviewDTO>();

        AvailableInterviewDTO availableInterviewDTO = new AvailableInterviewDTO();
        InterviewDTO interviewDTO = new InterviewDTO();
        interviewDTO.setInterviewDate(new Date());
        availableInterviewDTO.setInterview(interviewDTO);
        List<Long> interviewTimes = new ArrayList<Long>();
        interviewTimes.add(2000L);
        interviewTimes.add(200000L);
        availableInterviewDTO.setInterviewTimeList(interviewTimes);
        availableInterviewDTOs.add(availableInterviewDTO);

        getView().setAvailableInterviews(availableInterviewDTOs);*/
    }

    private void joinInterview() {
        dispatcher.execute(new AcceptInterviewAction(getView().getSelectedInterview()), new DefaultAsyncCallback<NoResult>() {
            @Override
            public void onSuccess(NoResult result) {
                currentUser.getUser().getStudentDetail().setUserStatus(null);

                LoginAuthenticatedEvent.fire(getEventBus(), currentUser);

                placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.INTERVIEW).build());
            }
        });
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }


    public interface ViewImpl extends View {

        void setAvailableInterviews(List<AvailableInterviewDTO> availableInterviewDTOList);

        Button getJoinInterviewButton();

        InterviewSlotDTO getSelectedInterview();

        Button getPrintButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_REGISTRATION_ON_INTERVIEW)
    public interface Proxy extends ProxyPlace<UserRegistrationOnInterviewPresenter> {
    }
}
