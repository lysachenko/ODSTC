package com.netcracker.tc.client.ui.presenter.user;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
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
import com.netcracker.tc.client.ui.layout.FullScreenLayoutPresenter;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.shared.model.user.RoleDTO;
import java.util.Date;

/**
 *
 * @author anla1215
 */
public class BadResumePresenter extends Presenter<BadResumePresenter.ViewImpl, BadResumePresenter.Proxy> {
    
    @Inject
    public BadResumePresenter(
            final EventBus eventBus,
            final BadResumePresenter.ViewImpl view,
            final BadResumePresenter.Proxy proxy) {
        super(eventBus, view, proxy);
    }
    
    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onReset() {
        super.onReset(); 
        
        getView().setBadResumeView();
    }
    
    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainLayoutPresenter.CONTENT_SLOT, this);
    }
    
    
    public interface ViewImpl extends View {
            void setBadResumeView();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @GatekeeperParams(value = {RoleDTO.ROLE_USER})
    @NameToken(NameTokens.User.BAD_RESUME)
    public interface Proxy extends ProxyPlace<BadResumePresenter> {
    }
    
}
