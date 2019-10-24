package com.netcracker.tc.client.ui.widget.common;

import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;

public class AppLoadingView extends ViewImpl implements AppLoadingPresenterWidget.Display
{
    private final PopupPanel popup = new PopupPanel();
    private final FlowPanel container = new FlowPanel();

    public AppLoadingView()
    {
        final Image ajaxImage = new Image("path_to_ajax_wait_image");
        final Grid grid = new Grid(1, 2);
        grid.setWidget(0, 0, ajaxImage);
        grid.setText(0, 1, "Loading...");
        this.container.add(grid);
        popup.add(this.container);
        initWidget(popup);
    }

    @Override
    public void stopProcessing()
    {
        popup.hide();
    }

    @Override
    public void startProcessing()
    {
        popup.center();
        popup.show();
    }
}