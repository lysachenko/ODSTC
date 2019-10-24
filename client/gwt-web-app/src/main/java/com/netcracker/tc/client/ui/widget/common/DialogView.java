package com.netcracker.tc.client.ui.widget.common;

import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewCloseHandler;
import com.gwtplatform.mvp.client.PopupViewImpl;

public class DialogView extends PopupViewImpl {

    protected Widget widget;
    protected Modal modal;

    public DialogView(EventBus eventBus) {
        super(eventBus);
        setUpDialog();
        initWidget(modal);
    }

    private void setUpDialog() {
        modal = new Modal() {

            @Override
            protected void onUnload() {
                DialogView.this.hide();
            }
        };
        modal.setBackdrop(BackdropType.STATIC);
        modal.setAnimation(true);
        modal.setKeyboard(true);
    }

    @Override
    public final void hide() {
        modal.hide();
    }

    @Override
    public void setAutoHideOnNavigationEventEnabled(final boolean autoHide) {
    }

    @Override
    public void setCloseHandler(final PopupViewCloseHandler popupViewCloseHandler) {
    }

    @Override
    public void setPosition(final int left, final int top) {
    }

    @Override
    public void show() {
        modal.show();
    }

    @Override
    public void center() {
        modal.show();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    protected final void initWidget(final Widget widget) {
        this.widget = widget;
    }
}
