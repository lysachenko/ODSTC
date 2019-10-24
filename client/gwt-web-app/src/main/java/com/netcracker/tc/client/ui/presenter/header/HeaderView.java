package com.netcracker.tc.client.ui.presenter.header;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderView extends ViewImpl implements HeaderPresenter.HeaderView {

    interface Binder extends UiBinder<Widget, HeaderView> {
    }

    @UiField
    HTMLPanel leftMenuBar;

    @UiField
    HTMLPanel rigthMenuBar;

    @Inject
    HeaderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == HeaderPresenter.LEFT_SLOT) {
            setCenterMenu(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    @Override
    public void setRightMenu(Widget content) {
        rigthMenuBar.clear();
        if (content != null) {
            rigthMenuBar.add(content);
        }
    }

    private void setCenterMenu(IsWidget content) {
        leftMenuBar.clear();
        if (content != null) {
            leftMenuBar.add(content);
        }
    }
}