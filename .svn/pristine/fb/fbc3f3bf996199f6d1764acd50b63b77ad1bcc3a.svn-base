package com.netcracker.tc.client.application;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.GaAccount;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

    private static final String ANALYTICS_ACCOUNT = "UA-8319339-6";

    @Override
    protected void configure() {
        install(new DefaultModule());
        install(new RpcDispatchAsyncModule());
        install(new ApplicationModule());

        bindConstant().annotatedWith(SecurityCookie.class).to("JSESSIONID");

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.HOME);

        bindConstant().annotatedWith(GaAccount.class).to(ANALYTICS_ACCOUNT);
    }
}
