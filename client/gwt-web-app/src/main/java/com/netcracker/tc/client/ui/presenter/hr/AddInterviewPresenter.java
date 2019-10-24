package com.netcracker.tc.client.ui.presenter.hr;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.netcracker.tc.shared.action.interview.AddInterviewAction;
import com.netcracker.tc.shared.model.interview.InterviewDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class AddInterviewPresenter extends PresenterWidget<AddInterviewPresenter.AddInterviewView> {

    @Inject
    private DispatchAsync dispatcher;

    private InterviewListPresenter interviewListPresenter;

    @Inject
    public AddInterviewPresenter(final EventBus eventBus, final AddInterviewView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InterviewDTO interview = getView().getInterview();

                dispatcher.execute(new AddInterviewAction(interview), new AsyncCallback<NoResult>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        GWT.log(caught.getMessage(), caught);
                        Window.alert("Error!!!." + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(NoResult result) {
                        getView().hide();
                        interviewListPresenter.reloadInterviewTable();
                    }
                });
            }
        });

        getView().getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getView().hide();
            }
        });
    }

    public void setInterviewListPresenter(InterviewListPresenter interviewListPresenter) {
        this.interviewListPresenter = interviewListPresenter;
    }

    public interface AddInterviewView extends PopupView {

        Button getSaveButton();

        Button getCancelButton();

        InterviewDTO getInterview();
    }
}

