package com.netcracker.tc.client.ui.widget.common;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.netcracker.tc.client.event.AppLoadingEvent;
import com.netcracker.tc.client.event.AppLoadingEventHandler;

public class AppLoadingPresenterWidget extends
        PresenterWidget<AppLoadingPresenterWidget.Display>
{
    public interface Display extends View
    {
        void stopProcessing();

        void startProcessing();
    }

    @Inject
    public AppLoadingPresenterWidget(Display view, EventBus eventBus)
    {
        super(eventBus, view);
    }

    @Override
    protected void onBind()
    {
        addRegisteredHandler(AppLoadingEvent.getType(), new AppLoadingEventHandler() {
            @Override
            public void onAppLoadingEvent(boolean isComplete) {
                if (isComplete) {
                    getView().stopProcessing();
                } else {
                    getView().startProcessing();
                }
            }
        });
    }
}
