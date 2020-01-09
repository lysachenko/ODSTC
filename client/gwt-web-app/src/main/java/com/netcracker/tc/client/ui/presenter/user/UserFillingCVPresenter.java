package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.netcracker.tc.client.ui.widget.resume.QAResumeWidget;
import com.netcracker.tc.server.persistence.model.resume.ResumePreparedStatus;
import com.netcracker.tc.shared.action.resume.*;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class UserFillingCVPresenter extends Presenter<UserFillingCVPresenter.ViewImpl, UserFillingCVPresenter.Proxy> {

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_RESUME)
    public interface Proxy extends ProxyPlace<UserFillingCVPresenter> {
    }

    public interface ViewImpl extends View {
        void setResumePanel(Widget widget);

        Button getBackStepButton();

        Button getNextStepButton();
    }
//    @Autowired

    //    private Logger LOGGER ;
    @Inject
    private PlaceManager placeManager;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private DevResumeWidget devResumeWidget;
    @Inject
    private QAResumeWidget qaResumeWidget;

    @Inject
    private DispatchAsync dispatcher;

    @Inject
    public UserFillingCVPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
        super.onBind();

        getView().getNextStepButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
//                if (currentUser.getPosition().isDev()) {

                saveDevResume();

//                } else {
//                    saveQAResume();
//                }
            }
        });

        getView().getBackStepButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_POSITION).build());
            }
        });
    }

    @Override
    protected void onReset() {

// TODO anky0315
        if (currentUser.getPosition().isDev()) {
            getView().setResumePanel(devResumeWidget);

            dispatcher.execute(new GetDevResumeAction(), new DefaultAsyncCallback<GetDevResumeResult>() {

                @Override
                public void onSuccess(GetDevResumeResult result) {
                    devResumeWidget.setInstitutes(result.getInstituteDTOList());
                    devResumeWidget.setKnowledgeTypes(result.getKnowledgeTypeDTOList());
                    devResumeWidget.setDevResume(result.getResume());
                }
            });
        } else {
            getView().setResumePanel(qaResumeWidget);

            dispatcher.execute(new GetQAResumeAction(), new DefaultAsyncCallback<GetQAResumeResult>() {
                @Override
                public void onSuccess(GetQAResumeResult result) {
                    qaResumeWidget.setInstitutes(result.getInstituteDTOList());
                    qaResumeWidget.setQAResume(result.getQaResumeDetailDTO());
                }
            });
        }
//
    }
//
//    private void saveQAResume() {
//        if (qaResumeWidget.isValid()) {
//            dispatcher.execute(new EditQAResumeAction(qaResumeWidget.getQAResume()), new DefaultAsyncCallback<NoResult>() {
//                @Override
//                public void onSuccess(NoResult result) {
//                    redirectToDatePage();
//                }
//            });
//        }

//    }

    private void saveDevResume() {
        if (devResumeWidget.isValid()) {

            dispatcher.execute(
                    new CreateDevResumeAction(devResumeWidget.getDevResume(
                                    ResumePreparedStatus.CREATED)),
                    new DefaultAsyncCallback<IsDevResumeValid>() {
                        @Override
                        public void onSuccess(IsDevResumeValid result) {
                            redirectToVerification();
                        }
                    });

        }
    }

    private void redirectToExit() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.BAD_RESUME).build());
    }

    private void redirectToVerification() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_VERIFICATION_CV).build());
    }

//    private void redirectToDatePage() {
//        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_REGISTRATION_ON_INTERVIEW).build());

//    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }
}
