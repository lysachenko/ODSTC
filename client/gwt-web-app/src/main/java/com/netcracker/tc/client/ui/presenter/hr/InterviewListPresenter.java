package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
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
import com.netcracker.tc.client.ui.widget.interview.InterviewAsyncTableWidget;
import com.netcracker.tc.shared.ServicePath;
import com.netcracker.tc.shared.action.interview.ActivateInterviewAction;
import com.netcracker.tc.shared.action.interview.DeleteInterviewAction;
import com.netcracker.tc.shared.action.interview.GetInterviewListAction;
import com.netcracker.tc.shared.action.interview.GetInterviewListResult;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class InterviewListPresenter extends Presenter<InterviewListPresenter.ViewImpl, InterviewListPresenter.Proxy> {
    private final DispatchAsync dispatcher;
    @Inject
    AddInterviewPresenter addInterviewPresenter;

    @Inject
    public InterviewListPresenter(EventBus eventBus, ViewImpl view, Proxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
    }

    protected void revealInParent() {
        RevealContentEvent.fire(this, FullScreenLayoutPresenter.CONTENT_SLOT, this);
    }

    protected void onBind() {
        this.addInterviewPresenter.setInterviewListPresenter(this);

        getView().getAddInterviewButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                InterviewListPresenter.this.addToPopupSlot(InterviewListPresenter.this.addInterviewPresenter);
            }
        });

        getView().getDeleteInterviewButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InterviewDTO selected = (InterviewListPresenter.this.getView()).getInterviewTable().getSelected();
                if (selected != null) {
                    dispatcher.execute(new DeleteInterviewAction(selected.getId()), new DefaultAsyncCallback<NoResult>() {
                        @Override
                        public void onSuccess(NoResult result) {
                            reloadInterviewTable();
                        }
                    });
                }
            }
        });

        getView().getInterviewTable().setDataProvider(new AsyncDataProvider<InterviewDTO>() {
            protected void onRangeChanged(HasData<InterviewDTO> display) {
                InterviewListPresenter.this.reloadInterviewTable();
            }
        });
        getView().getStartRegistrationButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                InterviewDTO selected = (InterviewListPresenter.this.getView()).getInterviewTable().getSelected();
                if (selected != null) {
                    InterviewListPresenter.this.activateInterview(selected.getId().longValue(), true);
                }
            }
        });
        getView().getStopRegistrationButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                InterviewListPresenter.this.activateInterview(InterviewListPresenter.this.getView().getInterviewTable().getSelected().getId().longValue(), false);
            }
        });
        getView().getGetInterviewResultsButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.open(ServicePath.INTERVIEW_RESULT_SERVLET_PATH, "", "");
            }
        });

        getView().getDetailInfoButton().addClickHandler(
                (new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        Window.open(ServicePath.DETAIL_INFO_SERVLET_PATH, "", "");
                    }
                }));



    }

    protected void onReset() {
        reloadInterviewTable();
    }

    public void reloadInterviewTable() {
        PagingLoadConfigDTO loadConfig = (getView()).getInterviewTable().getPagingLoadConfig();

        this.dispatcher.execute(new GetInterviewListAction(loadConfig), new DefaultAsyncCallback<GetInterviewListResult>() {
            public void onSuccess(GetInterviewListResult result) {
                InterviewListPresenter.this.getView().getInterviewTable().setValues(result.getPagingLoadResult());
            }
        });
    }

    private void activateInterview(long interviewId, boolean activate) {
        this.dispatcher.execute(new ActivateInterviewAction(Long.valueOf(interviewId), activate), new DefaultAsyncCallback<NoResult>() {
            public void onSuccess(NoResult result) {
                InterviewListPresenter.this.reloadInterviewTable();
            }
        });
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams({RoleDTO.ROLE_HR})
    @NameToken(NameTokens.Hr.INTERVIEW)
    public interface Proxy extends ProxyPlace<InterviewListPresenter> {
    }

    public interface ViewImpl extends View {
        public InterviewAsyncTableWidget getInterviewTable();

        public Button getDeleteInterviewButton();

        public Button getAddInterviewButton();

        public Button getStartRegistrationButton();

        public Button getStopRegistrationButton();

        public Button getGetInterviewResultsButton();

        public Button getDetailInfoButton();


    }
}
