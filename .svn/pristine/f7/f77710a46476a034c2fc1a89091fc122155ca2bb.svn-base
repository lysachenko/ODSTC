package com.netcracker.tc.client.ui.widget.common;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class AbstractPowerTableWidget extends Composite {

    private FlexTable flexTable;

    public AbstractPowerTableWidget(){
        flexTable = new FlexTable();
        flexTable.setWidget(0, 0, new Label("0,0"));
        flexTable.setWidget(0, 1, new Label("FlexTable"));
        flexTable.setWidget(0, 2, new Label("0,2"));
        flexTable.setWidget(1, 0, new Label("1,0"));
        flexTable.setWidget(1, 1, new Label("1,1"));
        flexTable.setWidget(1, 2, new Label("1,2"));
        flexTable.setWidget(2, 0, new Label("2,0"));
        flexTable.setWidget(2, 1, new Label("2,1"));
        flexTable.setWidget(2, 2, new Label("2,2"));
        flexTable.setWidget(3, 0, new Label("3,0 - span columns"));
        flexTable.setStyleName("panel flexTable");
        flexTable.getFlexCellFormatter().setColSpan(3, 0, 3);
        for (int i = 0; i < flexTable.getRowCount(); i++) {
            for (int j = 0; j < flexTable.getCellCount(i); j++) {
                if ((j % 2) == 0) {
                    flexTable.getFlexCellFormatter()
                            .setStyleName(i, j, "tableCell-even");
                } else {
                    flexTable.getFlexCellFormatter()
                            .setStyleName(i, j, "tableCell-odd");
                }
            }
        }

        initWidget(flexTable);
    }
}