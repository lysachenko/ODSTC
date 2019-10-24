package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;

/**
 * Created by unconsionable on 18.07.2014.
 */
public class TimeBox extends Composite {

    private ListBox timeListBox;

    /**
     * By default the predefined SHORT time format will be used.
     */
    public TimeBox() {
        initWidget(timeListBox = new ListBox());

        for (int i=0; i<24; i++){
            timeListBox.addItem(i+":00");
            timeListBox.addItem(i+":30");
        }

        timeListBox.setWidth("80px");
    }

    public Long getValue(){
        String value = timeListBox.getValue();
        long hour;
        long min;
        if (value.length() == 4){
            hour = Long.valueOf(value.substring(0, 1));
            min = Long.valueOf(value.substring(2,4));
        } else {
            hour = Long.valueOf(value.substring(0, 2));
            min = Long.valueOf(value.substring(3,5));
        }

        return (hour * 60 + min) * 60 * 1000;
    }

    public void addChangeChandler(ChangeHandler handler){
        timeListBox.addChangeHandler(handler);
    }
}