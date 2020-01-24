package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
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
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.shared.action.interview.GetUserInformationAction;
import com.netcracker.tc.shared.action.interview.GetUserInformationResult;
import com.netcracker.tc.shared.action.resume.SubmitDevResumeAction;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class UserVerificationCVPresenter extends Presenter<UserVerificationCVPresenter.ViewImpl, UserVerificationCVPresenter.Proxy> {

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_VERIFICATION_CV)
    public interface Proxy extends ProxyPlace<UserVerificationCVPresenter> {
    }

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
    private CurrentUser currentUser;
    @Inject
    private final DispatchAsync dispatcher;
    @Inject
    private PlaceManager placeManager;

    @Inject
    public UserVerificationCVPresenter(
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

        getView().getEditResumeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                editResume();
            }
        });

        getView().getSubmitResumeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                submitResume();
            }
        });

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

    private void editResume() {
//        if (devResumeWidget.isValid()) {
            redirectToEditing();
//        }
    }

    private void redirectToEditing() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_EDITING_CV).build());
    }


    private void submitResume() {
        if (devResumeWidget.isValid()) {

            dispatcher.execute(
                    new SubmitDevResumeAction(devResumeWidget.getDevResume()),
                    new DefaultAsyncCallback<NoResult>() {
                        @Override
                        public void onSuccess(NoResult result) {
                            Window.alert("Анкета отправлена");
                            redirectToSubmission();
                        }
                    }
            );
        }
    }

    private void redirectToSubmission() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_SUBMISSION_CV).build());
    }
}
