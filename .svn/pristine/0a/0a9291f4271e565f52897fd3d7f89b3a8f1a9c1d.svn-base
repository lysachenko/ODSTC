package com.netcracker.tc.client.ui.presenter.interviewer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.SelectionChangeEvent;
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
import com.netcracker.tc.client.ui.layout.FullScreenLayoutPresenter;
import com.netcracker.tc.client.ui.widget.hr.DevUserInterviewResultWidget;
import com.netcracker.tc.client.ui.widget.hr.QAUserInterviewResultWidget;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.client.ui.widget.resume.QAResumeWidget;
import com.netcracker.tc.client.ui.widget.user.UserFilterWidget;
import com.netcracker.tc.client.ui.widget.user.UserTableWidget;
import com.netcracker.tc.shared.action.interview.EditDevInterviewResultAction;
import com.netcracker.tc.shared.action.interview.GetUserInformationAction;
import com.netcracker.tc.shared.action.interview.GetUserInformationResult;
import com.netcracker.tc.shared.action.user.GetUserListAction;
import com.netcracker.tc.shared.action.user.GetUserListResult;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

public class DevUserInterviewListPresenter extends Presenter<DevUserInterviewListPresenter.ViewImpl, DevUserInterviewListPresenter.Proxy> {

    private final DispatchAsync dispatcher;

    @Inject
    CurrentUser currentUser;

    @Inject
    public DevUserInterviewListPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy,
            final DispatchAsync dispatcher) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, FullScreenLayoutPresenter.CONTENT_SLOT, this);
    }

    @Override
    protected void onBind() {
        getView().getUserTableWidget().setDataProvider(new AsyncDataProvider<UserDTO>() {
            @Override
            protected void onRangeChanged(HasData<UserDTO> display) {
                reloadUserInterviewTable();
            }
        });

        getView().getUserFilterWidget().getApplyFilter().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                reloadUserInterviewTable();
            }
        });

        getView().getUserTableWidget().addSelectionHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                UserDTO selectedUser = getView().getUserTableWidget().getSelected();

                if (selectedUser != null){
                    reloadUserInformation(selectedUser);
                }
            }
        });

        getView().getDevUserInterviewResultWidget().getSaveInterviewResultButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InterviewResultDTO interviewResult = getView().getDevUserInterviewResultWidget().getInterviewResult();

                try {
                    if (interviewResult != null) {
                        //TODO move to handler.
                        if(interviewResult.getDevInterviewResultDetail() != null && interviewResult.getDevInterviewResultDetail().getInterviewerOtherInformation().length() > 500) {
                            throw new IllegalArgumentException("DEV отзыв слишком длинный (более 500 символов).");
                        }
                        if(interviewResult.getDevInterviewResultDetail() != null && interviewResult.getDevInterviewResultDetail().getJavaSkill().length() > 400) {
                            throw new IllegalArgumentException("DEV JAVA Skill отзыв слишком длинный (более 400 символов).");
                        }
                        if(interviewResult.getDevInterviewResultDetail() != null && interviewResult.getDevInterviewResultDetail().getSqlSkill().length() > 400) {
                            throw new IllegalArgumentException("DEV SQL Skill отзыв слишком длинный (более 400 символов).");
                        }

                        dispatcher.execute(new EditDevInterviewResultAction(interviewResult), new DefaultAsyncCallback<NoResult>() {
                            @Override
                            public void onSuccess(NoResult result) {
                                Window.alert("Изменения сохранены");
                            }
                        });
                    }
                } catch (Exception ex) {
                    Window.alert("Изменения не сохранены! Детали ошибки: " + ex.getMessage());
                }
            }
        });

        getView().getQaUserInterviewResultWidget().getSaveInterviewResultButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InterviewResultDTO interviewResult = getView().getQaUserInterviewResultWidget().getInterviewResult();

                if (interviewResult != null) {
                    dispatcher.execute(new EditDevInterviewResultAction(interviewResult), new DefaultAsyncCallback<NoResult>() {
                        @Override
                        public void onSuccess(NoResult result) {
                            Window.alert("Изменения сохранены");
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onReset() {
        getView().getDevResumeWidget().disableFields();
        getView().getDevUserInterviewResultWidget().enableDevFields();
        getView().getQAResumeWidget().disableFields();
        getView().getQaUserInterviewResultWidget().enableDevFields();
    }

    private void reloadUserInformation(UserDTO selectedUser) {
        dispatcher.execute(new GetUserInformationAction(selectedUser.getId()), new DefaultAsyncCallback<GetUserInformationResult>() {
            @Override
            public void onSuccess(GetUserInformationResult result) {
                if (result.getPositionDTO() == null){
                    getView().getDevUserInterviewResultWidget().showEmptyPanel();
                    getView().getQaUserInterviewResultWidget().showEmptyPanel();
                    getView().getDevResumeWidget().clearFields();
                    getView().getQAResumeWidget().clearFields();
                    return;
                }

                if (result.getPositionDTO().isDev()) {
                    getView().showDevViews(true);

                    getView().getDevResumeWidget().setKnowledgeTypes(result.getKnowledgeTypeDTOList());
                    getView().getDevResumeWidget().setInstitutes(result.getInstituteDTOList());
                    getView().getDevResumeWidget().setDevResume(result.getResume());
                    getView().getDevUserInterviewResultWidget().setIsArchive(result.isArchiveUser());

                    getView().getDevUserInterviewResultWidget().setInterviewResult(result.getInterviewSlot(), result.getInterviewResultDTO());
                    if (result.getInterviewSlot() != null) {
                        getView().getDevUserInterviewResultWidget().showInterviewResultPanel();
                    } else {
                        getView().getDevUserInterviewResultWidget().showNoInterviewPanel();
                    }
                } else {
                    getView().showDevViews(false);

                    getView().getQAResumeWidget().setInstitutes(result.getInstituteDTOList());
                    getView().getQAResumeWidget().setQAResume(result.getResume());
                    getView().getQaUserInterviewResultWidget().setIsArchive(result.isArchiveUser());

                    getView().getQaUserInterviewResultWidget().setInterviewResult(result.getInterviewSlot(), result.getInterviewResultDTO());
                    if (result.getInterviewSlot() != null) {
                        getView().getQaUserInterviewResultWidget().showInterviewResultPanel();
                    } else {
                        getView().getQaUserInterviewResultWidget().showNoInterviewPanel();
                    }
                }
            }
        });
    }

    public void reloadUserInterviewTable() {
        PagingLoadConfigDTO loadConfig = getView().getUserTableWidget().getPagingLoadConfig();

        UserPagingFilterDTO userPagingFilterDTO = getView().getUserFilterWidget().getFilter();
        getView().getDevUserInterviewResultWidget().showEmptyPanel();
        getView().getDevResumeWidget().clearFields();
//        getView().getQaUserInterviewResultWidget().showEmptyPanel();
//        getView().getQAResumeWidget().clearFields();

        dispatcher.execute(new GetUserListAction(loadConfig, userPagingFilterDTO), new DefaultAsyncCallback<GetUserListResult>() {

            @Override
            public void onSuccess(GetUserListResult result) {
                getView().getUserTableWidget().setValues(result.getPagingLoadResult());
            }
        });
    }

    public interface ViewImpl extends View {

        UserTableWidget getUserTableWidget();

        UserFilterWidget getUserFilterWidget();

        DevResumeWidget getDevResumeWidget();

        DevUserInterviewResultWidget getDevUserInterviewResultWidget();

        QAUserInterviewResultWidget getQaUserInterviewResultWidget();

        QAResumeWidget getQAResumeWidget();

        void showDevViews(boolean devViews);
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_INTERVIEWER})
    @NameToken(NameTokens.Interviewer.USERS)
    public interface Proxy extends ProxyPlace<DevUserInterviewListPresenter> {
    }
}