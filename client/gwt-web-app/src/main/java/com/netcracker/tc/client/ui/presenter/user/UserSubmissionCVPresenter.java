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
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.netcracker.tc.client.application.LoggedInGatekeeper;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.shared.action.interview.GetUserInformationAction;
import com.netcracker.tc.shared.action.interview.GetUserInformationResult;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class UserSubmissionCVPresenter extends Presenter<UserSubmissionCVPresenter.ViewImpl, UserSubmissionCVPresenter.Proxy> {

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_SUBMISSION_CV)
    public interface Proxy extends ProxyPlace<UserSubmissionCVPresenter> {
    }

    public interface ViewImpl extends View {
        void updateMessage();

        void setMessage(String message);

        HTMLPanel getResumePanel();

        DevResumeWidget getDevResumeWidget();

        void setResumePanel(Widget widget);
    }

    @Inject
    private DevResumeWidget devResumeWidget;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private final DispatchAsync dispatcher;

    @Inject
    public UserSubmissionCVPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy,
            DispatchAsync dispatcher
    ) {
        super(eventBus, view, proxy);
        this.dispatcher = dispatcher;
    }

    @Override
    protected void onBind() {
        super.onBind();

        loadUserInformation();
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
        loadUserInformation();
    }

    private void loadUserInformation() {
        dispatcher.execute(new GetUserInformationAction(currentUser.getUser().getId()), new DefaultAsyncCallback<GetUserInformationResult>() {
            @Override
            public void onSuccess(GetUserInformationResult result) {
                getView().getDevResumeWidget().clearFields();

                getView().getDevResumeWidget().setKnowledgeTypes(result.getKnowledgeTypeDTOList());
                getView().getDevResumeWidget().setInstitutes(result.getInstituteDTOList());
                getView().getDevResumeWidget().setDevResume(result.getResume());

            }
        });
    }
}
