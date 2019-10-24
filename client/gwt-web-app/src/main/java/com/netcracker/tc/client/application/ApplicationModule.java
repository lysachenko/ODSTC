package com.netcracker.tc.client.application;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.netcracker.tc.client.ui.layout.FullScreenLayoutPresenter;
import com.netcracker.tc.client.ui.layout.FullScreenLayoutView;
import com.netcracker.tc.client.ui.layout.MainLayoutPresenter;
import com.netcracker.tc.client.ui.layout.MainLayoutView;
import com.netcracker.tc.client.ui.presenter.admin.*;
import com.netcracker.tc.client.ui.presenter.authorization.AuthorizationPresenter;
import com.netcracker.tc.client.ui.presenter.authorization.AuthorizationView;
import com.netcracker.tc.client.ui.presenter.authorization.RegistrationPresenter;
import com.netcracker.tc.client.ui.presenter.authorization.RegistrationView;
import com.netcracker.tc.client.ui.presenter.header.HeaderPresenter;
import com.netcracker.tc.client.ui.presenter.header.HeaderView;
import com.netcracker.tc.client.ui.presenter.header.SimpleHeaderPresenter;
import com.netcracker.tc.client.ui.presenter.header.SimpleHeaderView;
import com.netcracker.tc.client.ui.presenter.home.*;
import com.netcracker.tc.client.ui.presenter.hr.*;
import com.netcracker.tc.client.ui.presenter.interviewer.DevUserInterviewListPresenter;
import com.netcracker.tc.client.ui.presenter.interviewer.DevUserInterviewListView;
import com.netcracker.tc.client.ui.presenter.user.*;
import com.netcracker.tc.client.ui.widget.common.AppLoadingPresenterWidget;
import com.netcracker.tc.client.ui.widget.common.AppLoadingView;
import com.netcracker.tc.client.ui.widget.dialog.AlertDialogPresenter;
import com.netcracker.tc.client.ui.widget.dialog.AlertDialogView;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.LoginLogoutView;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarPresenterWidget;
import com.netcracker.tc.client.ui.widget.navigation.NavigationBarView;
import com.netcracker.tc.shared.model.user.CurrentUser;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bind(LoggedInGatekeeper.class).in(Singleton.class);
        bind(CurrentUser.class).in(Singleton.class);
        bind(AppLoadingPresenterWidget.class).in(Singleton.class);

        bindCommonPresenter();
        bindAdminPresenters();
        bindUserPresenters();
        bindInterviewerPresenters();
        bindHrPresenters();
    }

    private void bindCommonPresenter() {
        bindPresenter(MainLayoutPresenter.class, MainLayoutPresenter.MainLayoutView.class,
                MainLayoutView.class, MainLayoutPresenter.MainLayoutProxy.class);
        bindPresenter(FullScreenLayoutPresenter.class, FullScreenLayoutPresenter.FullScreenLayoutView.class,
                FullScreenLayoutView.class, FullScreenLayoutPresenter.FullScreenLayoutProxy.class);

        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(DevHomePresenter.class, DevHomePresenter.MyView.class, DevHomeView.class, DevHomePresenter.MyProxy.class);
        bindPresenter(QAHomePresenter.class, QAHomePresenter.MyView.class, QAHomeView.class, QAHomePresenter.MyProxy.class);

        bindPresenter(HeaderPresenter.class, HeaderPresenter.HeaderView.class, HeaderView.class, HeaderPresenter.HeaderProxy.class);
        bindPresenter(SimpleHeaderPresenter.class, SimpleHeaderPresenter.HeaderView.class, SimpleHeaderView.class, SimpleHeaderPresenter.HeaderProxy.class);

        bindPresenterWidget(LoginLogoutPresenterWidget.class, LoginLogoutPresenterWidget.View.class, LoginLogoutView.class);
        bindPresenterWidget(AuthorizationPresenter.class, AuthorizationPresenter.AuthorizationView.class, AuthorizationView.class);
        bindPresenterWidget(RegistrationPresenter.class, RegistrationPresenter.RegistrationView.class, RegistrationView.class);
        bindPresenterWidget(NavigationBarPresenterWidget.class, NavigationBarPresenterWidget.NavigationBarView.class, NavigationBarView.class);
        bindPresenterWidget(AppLoadingPresenterWidget.class, AppLoadingPresenterWidget.Display.class, AppLoadingView.class);
        bindPresenterWidget(AlertDialogPresenter.class, AlertDialogPresenter.View.class, AlertDialogView.class);
    }

    private void bindAdminPresenters() {
        bindPresenter(UserListPresenter.class, UserListPresenter.ViewImpl.class, UserListView.class, UserListPresenter.Proxy.class);

        bindPresenterWidget(AddUserPresenter.class, AddUserPresenter.AddUserView.class, AddUserView.class);
        bindPresenterWidget(ChangePasswordPresenter.class, ChangePasswordPresenter.ChangePasswordView.class, ChangePasswordView.class);
    }

    private void bindUserPresenters() {
        bindPresenter(UserResumePresenter.class, UserResumePresenter.ViewImpl.class, UserResumeView.class, UserResumePresenter.Proxy.class);
        bindPresenter(UserInterviewPresenter.class, UserInterviewPresenter.ViewImpl.class, UserInterviewView.class, UserInterviewPresenter.Proxy.class);
        bindPresenter(UserJoinInterviewPresenter.class, UserJoinInterviewPresenter.ViewImpl.class, UserJoinInterviewView.class, UserJoinInterviewPresenter.Proxy.class);

        bindPresenter(BadResumePresenter.class, BadResumePresenter.ViewImpl.class, BadResumeView.class, BadResumePresenter.Proxy.class);        
        
        bindPresenter(UserFirstEntryStep1Presenter.class, UserFirstEntryStep1Presenter.ViewImpl.class, UserFirstEntryStep1View.class, UserFirstEntryStep1Presenter.Proxy.class);
        bindPresenter(UserFillingCVPresenter.class, UserFillingCVPresenter.ViewImpl.class, UserFillingCVView.class, UserFillingCVPresenter.Proxy.class);
        bindPresenter(UserRegistrationOnInterviewPresenter.class, UserRegistrationOnInterviewPresenter.ViewImpl.class, UserRegistrationOnInterviewView.class, UserRegistrationOnInterviewPresenter.Proxy.class);
        bindPresenter(UserVerificationCVPresenter.class, UserVerificationCVPresenter.ViewImpl.class, UserVerificationCVView.class, UserVerificationCVPresenter.Proxy.class);
        bindPresenter(QAInformationPresenter.class, QAInformationPresenter.MyView.class, QAInformationView.class, QAInformationPresenter.MyProxy.class);
    }

    private void bindInterviewerPresenters() {
        bindPresenter(DevUserInterviewListPresenter.class, DevUserInterviewListPresenter.ViewImpl.class,
                DevUserInterviewListView.class, DevUserInterviewListPresenter.Proxy.class);
    }

    private void bindHrPresenters() {
        bindPresenter(MailListPresenter.class, MailListPresenter.ViewImpl.class, MailListView.class, MailListPresenter.Proxy.class);
        bindPresenter(InterviewListPresenter.class, InterviewListPresenter.ViewImpl.class, InterviewListView.class, InterviewListPresenter.Proxy.class);
        bindPresenter(HRUserInterviewListPresenter.class, HRUserInterviewListPresenter.ViewImpl.class, HRUserInterviewListView.class, HRUserInterviewListPresenter.Proxy.class);
        bindPresenter(InterviewResultListPresenter.class, InterviewResultListPresenter.ViewImpl.class, InterviewResultListView.class, InterviewResultListPresenter.Proxy.class);

        bindPresenter(SettingsPresenter.class, SettingsPresenter.ViewImpl.class, SettingsView.class, SettingsPresenter.Proxy.class);
        
        bindPresenterWidget(AddInterviewPresenter.class, AddInterviewPresenter.AddInterviewView.class, AddInterviewView.class);
        
        
    }
}