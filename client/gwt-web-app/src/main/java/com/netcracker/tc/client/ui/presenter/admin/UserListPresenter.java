package com.netcracker.tc.client.ui.presenter.admin;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.netcracker.tc.client.ui.widget.user.UserAsyncTableWidget;
import com.netcracker.tc.shared.action.user.DeleteUserAction;
import com.netcracker.tc.shared.action.user.GetUserListAction;
import com.netcracker.tc.shared.action.user.GetUserListResult;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

public class UserListPresenter extends Presenter<UserListPresenter.ViewImpl, UserListPresenter.Proxy> {

    private final DispatchAsync dispatcher;

    private AddUserPresenter addUserPresenter;
    private ChangePasswordPresenter changePasswordPresenter;

    @Inject
    public UserListPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy,
            final DispatchAsync dispatcher,
            final AddUserPresenter addUserPresenter,
            final ChangePasswordPresenter changePasswordPresenter) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
        this.addUserPresenter = addUserPresenter;
        this.changePasswordPresenter = changePasswordPresenter;
        addUserPresenter.setUserListPresenter(this);
        changePasswordPresenter.setUserListPresenter(this);
    }

    @Override
    protected void onReset() {
        reloadUserTable();
    }

    @Override
    protected void onBind() {
        getView().getUserTable().setDataProvider(new AsyncDataProvider<UserDTO>() {
            @Override
            protected void onRangeChanged(HasData<UserDTO> display) {
                reloadUserTable();
            }
        });

        getView().getAddUserButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addToPopupSlot(addUserPresenter);
            }
        });

        getView().getChangePasswordButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                UserDTO selectedUser = getView().getUserTable().getSelected();

                if (selectedUser != null) {
                    changePasswordPresenter.setUserId(selectedUser.getId());
                    addToPopupSlot(changePasswordPresenter, true);
                }
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
        PagingLoadConfigDTO loadConfig = getView().getUserTable().getPagingLoadConfig();

        getDispatcher().execute(new GetUserListAction(loadConfig, new UserPagingFilterDTO()), new DefaultAsyncCallback<GetUserListResult>() {

            @Override
            public void onSuccess(GetUserListResult result) {

                getView().getUserTable().setValues(result.getPagingLoadResult());
            }
        });
    }

    public interface ViewImpl extends View {

        UserAsyncTableWidget getUserTable();

        Button getAddUserButton();

        Button getChangePasswordButton();

//        Button getDeleteUserButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_ADMIN})
    @NameToken(NameTokens.Admin.USER_LIST)
    public interface Proxy extends ProxyPlace<UserListPresenter> {
    }
}