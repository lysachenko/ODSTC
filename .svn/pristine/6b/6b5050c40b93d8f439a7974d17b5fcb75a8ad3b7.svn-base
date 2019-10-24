package com.netcracker.tc.client.ui.layout;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class FullScreenLayoutView extends ViewImpl implements FullScreenLayoutPresenter.FullScreenLayoutView {

    @UiField
    HTMLPanel contentPanel;
    @UiField
    HTMLPanel centerHeaderPanel;
    @UiField
    HTMLPanel rightHeaderPanel;

    @Inject
    FullScreenLayoutView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == FullScreenLayoutPresenter.CONTENT_SLOT) {
            setContent(content);
        } else if (slot == FullScreenLayoutPresenter.HEADER_CENTER_SLOT) {
            setCenterHeaderPanel(content);
        } else if (slot == FullScreenLayoutPresenter.HEADER_RIGHT_SLOT) {
            setRightHeaderPanel(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    private void setContent(IsWidget content) {
        contentPanel.clear();
        if (content != null) {
            contentPanel.add(content);
        }
    }

    private void setCenterHeaderPanel(IsWidget content) {
        centerHeaderPanel.clear();
        if (content != null) {
            centerHeaderPanel.add(content);
        }
    }

    private void setRightHeaderPanel(IsWidget content) {
        rightHeaderPanel.clear();
        if (content != null) {
            rightHeaderPanel.add(content);
        }
    }

    interface Binder extends UiBinder<Widget, FullScreenLayoutView> {
    }
}
