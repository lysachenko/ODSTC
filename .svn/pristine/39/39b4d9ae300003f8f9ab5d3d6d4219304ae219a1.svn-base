package com.netcracker.tc.client.ui.layout;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author unconsionable
 */
public class MainLayoutView extends ViewImpl implements MainLayoutPresenter.MainLayoutView {

    @UiField
    HTMLPanel contentPanel;
    @UiField
    HTMLPanel centerHeaderPanel;
    @UiField
    HTMLPanel rightHeaderPanel;
    @UiField
    Image ncLogoImage;

    @Inject
    MainLayoutView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == MainLayoutPresenter.CONTENT_SLOT) {
            setContent(content);
        } else if (slot == MainLayoutPresenter.HEADER_CENTER_SLOT) {
            setCenterHeaderPanel(content);
        } else if (slot == MainLayoutPresenter.HEADER_RIGHT_SLOT) {
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

    @Override
    public Image getNcLogoImage() {
        return ncLogoImage;
    }

    interface Binder extends UiBinder<Widget, MainLayoutView> {
    }
}