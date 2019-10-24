package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.netcracker.tc.shared.action.resume.EditPositionAction;
import com.netcracker.tc.shared.model.user.CurrentUser;
import com.netcracker.tc.shared.model.user.PositionDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;

public class UserFirstEntryStep1Presenter extends Presenter<UserFirstEntryStep1Presenter.ViewImpl, UserFirstEntryStep1Presenter.Proxy> {

    @Inject
    private DispatchAsync dispatcher;
    @Inject
    private PlaceManager placeManager;
    @Inject
    private CurrentUser currentUser;


    @Inject
    public UserFirstEntryStep1Presenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void onBind() {
    // TODO anky0315;
        getView().getSelectDevButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                editUserPosition(new PositionDTO(2L , "Dev"));
            }
        });
    //
        getView().getSelectQAButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                editUserPosition(new PositionDTO(1L, "QA"));
            }
        });
    }
    private void redirectToQAPage() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.QA_PAGE).build());
    }

    private void editUserPosition(final PositionDTO position) {
        dispatcher.execute(new EditPositionAction(position), new DefaultAsyncCallback<NoResult>() {

            @Override
            public void onSuccess(NoResult result) {
                currentUser.setPosition(position);
                redirectToStep2();
            }
        });
    }

    private void redirectToStep2() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.User.STEP_RESUME).build());
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }

    public interface ViewImpl extends View {

        Button getSelectDevButton();

        Button getSelectQAButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.STEP_POSITION)
    public interface Proxy extends ProxyPlace<UserFirstEntryStep1Presenter> {
    }
}
