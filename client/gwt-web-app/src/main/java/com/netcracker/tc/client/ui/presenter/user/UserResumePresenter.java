package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
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
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.netcracker.tc.client.application.LoggedInGatekeeper;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.client.ui.widget.resume.DevResumeWidget;
import com.netcracker.tc.client.ui.widget.resume.QAResumeWidget;
import com.netcracker.tc.shared.ServicePath;
import com.netcracker.tc.shared.action.resume.*;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.logging.Logger;

public class UserResumePresenter extends Presenter<UserResumePresenter.ViewImpl, UserResumePresenter.Proxy> {
    private static Logger LOGGER = Logger.getLogger(UserResumePresenter.class.toString());
    @Inject
    private DispatchAsync dispatcher;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private DevResumeWidget devResumeWidget;
    @Inject
    private QAResumeWidget qaResumeWidget;

    @Inject
    public UserResumePresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
//        getView().getSaveButton().addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                if (currentUser.getPosition().isDev()) {
//                    saveDevResume(devResumeWidget.getDevResume());
//                } else {
//                    saveQAResume(qaResumeWidget.getQAResume());
//                }
//            }
//        });

        getView().getPrintButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ServicePath.DOWNLOAD_SERVLET_PATH, "", "");
            }
        });
    }

    @Override
    protected void onReset() {
        if (currentUser.getPosition().isDev()) {
            getView().setResumeWidget(devResumeWidget);

            getDispatcher().execute(new GetDevResumeAction(), new DefaultAsyncCallback<GetDevResumeResult>() {

                @Override
                public void onSuccess(GetDevResumeResult result) {
                    devResumeWidget.setInstitutes(result.getInstituteDTOList());
                    devResumeWidget.setKnowledgeTypes(result.getKnowledgeTypeDTOList());
                    devResumeWidget.setDevResume(result.getResume());
                    devResumeWidget.disableFields();
                }
            });
        } else {
            getView().setResumeWidget(qaResumeWidget);

            getDispatcher().execute(new GetQAResumeAction(), new DefaultAsyncCallback<GetQAResumeResult>() {

                @Override
                public void onSuccess(GetQAResumeResult result) {
                    qaResumeWidget.setInstitutes(result.getInstituteDTOList());
                    qaResumeWidget.setQAResume(result.getQaResumeDetailDTO());
                    qaResumeWidget.disableFields();
                }
            });
        }
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    public DispatchAsync getDispatcher() {
        return dispatcher;
    }

    private void saveDevResume(ResumeDTO resume) {
        if (devResumeWidget.isValid()) {
            getDispatcher().execute(new EditDevResumeAction(resume), new DefaultAsyncCallback<NoResult>() {

                @Override
                public void onSuccess(NoResult result) {
                    Window.alert("Изменения сохранены");
                }
            });
        }
    }

    private void saveQAResume(ResumeDTO resume) {
        if (qaResumeWidget.isValid()) {
            dispatcher.execute(new EditQAResumeAction(resume), new DefaultAsyncCallback<NoResult>() {
                @Override
                public void onSuccess(NoResult result) {
                    Window.alert("Изменения сохранены");
                }
            });
        }
    }

    public interface ViewImpl extends View {

        void setResumeWidget(Widget widget);

//        Button getSaveButton();

        Button getPrintButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.RESUME)
    public interface Proxy extends ProxyPlace<UserResumePresenter> {
    }
}