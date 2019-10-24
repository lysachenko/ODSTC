package com.netcracker.tc.client.ui.widget.navigation;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.netcracker.tc.client.application.NameTokens;
import com.netcracker.tc.shared.model.user.RoleDTO;

import java.util.*;

public class NavigationBarView extends ViewWithUiHandlers<NavigationUiHandlers> implements NavigationBarPresenterWidget.NavigationBarView {

    @UiField
    HorizontalPanel navigationBar;

    private Map<Long, List<NavData>> navigationDataMap;

    @Inject
    NavigationBarView(Binder uiBinder,
                      EventBus eventBus) {
        initWidget(uiBinder.createAndBindUi(this));

        navigationDataMap = new HashMap<Long, List<NavData>>();
        navigationDataMap.put(RoleDTO.ROLE_ADMIN_ID, Collections.singletonList(
                new NavData("Пользователи", NameTokens.Admin.USER_LIST)));
        navigationDataMap.put(RoleDTO.ROLE_USER_ID, Arrays.asList(
                new NavData("Главная", NameTokens.HOME_NC, true),
                new NavData("Анкета", NameTokens.User.RESUME),
                new NavData("Запись на собеседование", NameTokens.User.ENTRY_FOR_INTERVIEW),
                new NavData("Мое Собеседование", NameTokens.User.INTERVIEW)));
        navigationDataMap.put(RoleDTO.ROLE_HR_ID, Arrays.asList(
                new NavData("Студенты", NameTokens.Hr.USER_INTERVIEW),
                new NavData("Собеседования", NameTokens.Hr.INTERVIEW),
                new NavData("Результаты собеседований", NameTokens.Hr.INTERVIEW_RESULT),
                new NavData("Итоговый отчет по пользователям", NameTokens.Hr.USER_SUMMARY_REPORT, true),
                new NavData("Настройки", NameTokens.Hr.SETTINGS),
                new NavData("Почта", NameTokens.Hr.MAIL)));
    }

    @Override
    public void createNavigation(Long role) {
        navigationBar.clear();

        List<NavData> navDatas = navigationDataMap.get(role);
        if (navDatas != null) {
            for (NavData navData : navDatas) {
                addNavigation(navData);
            }
        }
    }

    private void addNavigation(final NavData navData) {
        Button navLink = new Button(navData.getName());
        navLink.setType(ButtonType.LINK);
        navLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!navData.isExternal()) {
                    getUiHandlers().navigate(navData.getToken());
                } else if (navData.getToken().equals(NameTokens.Hr.USER_SUMMARY_REPORT)) {
                    Window.open(navData.getToken(), "_blank", null);
                } else {
                    Window.Location.assign(navData.getToken());
                }
            }
        });
        navigationBar.add(navLink);

    }

    interface Binder extends UiBinder<Widget, NavigationBarView> {
    }

    private class NavData {

        private String name;
        private String token;
        final private Boolean external;

        public NavData(String name, String token) {
            this(name, token, false);
        }

        private NavData(String name, String token, Boolean external) {
            this.name = name;
            this.token = token;
            this.external = external;
        }

        public Boolean isExternal() {
            return external;
        }

        public String getName() {
            return name;
        }

        public String getToken() {
            return token;
        }
    }
}