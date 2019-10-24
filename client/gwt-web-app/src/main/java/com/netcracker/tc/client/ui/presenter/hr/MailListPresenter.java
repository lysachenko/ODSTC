package com.netcracker.tc.client.ui.presenter.hr;

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
import com.netcracker.tc.client.ui.widget.hr.MailAsyncTableWidget;
import com.netcracker.tc.shared.action.GetMailListResult;
import com.netcracker.tc.shared.action.common.GetMailListAction;
import com.netcracker.tc.shared.action.user.DeleteUserAction;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.MailFilterDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

public class MailListPresenter extends Presenter<MailListPresenter.ViewImpl, MailListPresenter.Proxy> {

    private final DispatchAsync dispatcher;

    @Inject
    public MailListPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy,
            final DispatchAsync dispatcher
    ) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onReset() {
        reloadUserTable();
    }

    @Override
    protected void onBind() {
        getView().getMailTable().setDataProvider(new AsyncDataProvider<MailDTO>() {
            @Override
            protected void onRangeChanged(HasData<MailDTO> display) {
                reloadUserTable();
            }
        });



//        getView().getDeleteUserButton().addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                UserDTO selectedUser = getView().getUserTable().getSelected();
//
//                if (selectedUser != null) {
//                    deleteUser(selectedUser);
//                }
//            }
//        });
    }

    private void deleteUser(UserDTO selectedUser) {
        getDispatcher().execute(new DeleteUserAction(selectedUser.getId()), new DefaultAsyncCallback<NoResult>() {
            @Override
            public void onSuccess(NoResult result) {
                reloadUserTable();
            }
        });
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, FullScreenLayoutPresenter.CONTENT_SLOT, this);
    }

    private DispatchAsync getDispatcher() {
        return dispatcher;
    }

    public void reloadUserTable() {
        PagingLoadConfigDTO loadConfig = getView().getMailTable().getPagingLoadConfig();

        getDispatcher().execute(new GetMailListAction(loadConfig, new MailFilterDTO()), new DefaultAsyncCallback<GetMailListResult>() {

            @Override
            public void onSuccess(GetMailListResult result) {

                getView().getMailTable().setValues(result.getPagingLoadResult());
            }
        });
    }

    public interface ViewImpl extends View {

        MailAsyncTableWidget getMailTable();

//        Button getAddUserButton();

//        Button getChangePasswordButton();

//        Button getDeleteUserButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_HR})
    @NameToken(NameTokens.Hr.MAIL)
    public interface Proxy extends ProxyPlace<MailListPresenter> {
    }
}