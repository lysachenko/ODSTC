package com.netcracker.tc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtplatform.mvp.client.ApplicationController;

public class MainEntryPoint implements EntryPoint {

    private final ApplicationController controller = GWT.create(ApplicationController.class);

    @Override
    public void onModuleLoad() {
        Scheduler sheduller = Scheduler.get();

        sheduller.scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                controller.init();

                RootPanel.get("loading").setVisible(false);
            }
        });
    }
}
