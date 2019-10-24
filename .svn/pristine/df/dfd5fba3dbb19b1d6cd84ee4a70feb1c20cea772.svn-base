package com.netcracker.tc.client.ui.presenter.header;

import com.github.gwtbootstrap.client.ui.Nav;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SimpleHeaderView extends ViewImpl implements SimpleHeaderPresenter.HeaderView {

    interface Binder extends UiBinder<Widget, SimpleHeaderView> {
    }

    @UiField
    Nav rigthMenuBar;

    @UiField
    Nav centerMenuBar;

    @Inject
    SimpleHeaderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == SimpleHeaderPresenter.CENTER_SLOT) {
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
        centerMenuBar.clear();
        if (content != null) {
            centerMenuBar.add(content);
        }
    }
}