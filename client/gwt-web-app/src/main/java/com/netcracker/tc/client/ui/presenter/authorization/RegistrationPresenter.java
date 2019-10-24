package com.netcracker.tc.client.ui.presenter.authorization;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.netcracker.tc.client.callback.DefaultAsyncCallback;
import com.netcracker.tc.shared.action.user.RegistrationStep1Action;
import com.netcracker.tc.shared.action.user.RegistrationStep2Action;
import com.netcracker.tc.shared.model.user.UserDTO;

public class RegistrationPresenter extends PresenterWidget<RegistrationPresenter.RegistrationView> {

    @Inject
    private DispatchAsync dispatcher;
    @Inject
    private PlaceManager placeManager;

    @Inject
    public RegistrationPresenter(EventBus eventBus, RegistrationView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        getView().getStep1Button().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String login = getView().getLoginField().getText();
                String password = getView().getPasswordField().getText();
                String confirmPassword = getView().getConfirmPasswordField().getText();

                if (!getView().isValid())
                    return;

                UserDTO user = new UserDTO();
                user.setPassword(password);
                user.setLogin(login);

//                seva0116 fix (disable-> feel all value on create tab-> close popup-> press registarion-> check visiability next button )
//                 needs for registations
//                getView().getStep1Button().setEnabled(false);

                dispatcher.execute(new RegistrationStep1Action(user, getView().getCaptchaField().getText()),
                        new DefaultAsyncCallback<NoResult>() {

                            @Override
                            public void onSuccess(NoResult result) {
                                getView().hideErrorMessage();
//                                seva0116 for mail
//                                getView().showStep2View();
                                getView().showStep3View();
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                getView().showErrorMessage(caught.getMessage());
//                               sevo0116 needs for registations
//                                getView().getStep1Button().setEnabled(true);
                            }
                        });


            }
        });

        getView().getStep2Button().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                UserDTO user = new UserDTO();
                user.setPassword(getView().getPasswordField().getText());
                user.setLogin(getView().getLoginField().getText());

                dispatcher.execute(new RegistrationStep2Action(user, getView().getCaptchaField().getText(),
                        getView().getEmailCodeField().getText()), new DefaultAsyncCallback<NoResult>() {
                    @Override
                    public void onSuccess(NoResult noResult) {
                        getView().hideErrorMessage();
                        getView().showStep3View();
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        getView().showErrorMessage(caught.getMessage());
                    }
                });
            }
        });

        getView().getRegistrationCompleteButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                getView().hide();
            }
        });
    }

    public void show() {
        getView().hideErrorMessage();
        getView().showStep1View();
        getView().refreshCaptcha();
        getView().show();
    }

    public interface RegistrationView extends PopupView {

        TextBox getLoginField();

        TextBox getCaptchaField();

        TextBox getEmailCodeField();

        PasswordTextBox getPasswordField();

        PasswordTextBox getConfirmPasswordField();

        Button getStep1Button();

        Button getStep2Button();

        Button getRegistrationCompleteButton();

        void showErrorMessage(String message);

        void hideErrorMessage();

        void refreshCaptcha();

        boolean isValid();

        void showStep1View();

        void showStep2View();

        void showStep3View();
    }
}