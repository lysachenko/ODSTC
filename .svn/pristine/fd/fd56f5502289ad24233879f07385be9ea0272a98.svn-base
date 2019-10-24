package com.netcracker.tc.client.ui.widget.common;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractStaticTableWidget<T extends Serializable> extends Composite {

    protected CellTable<T> table;
    protected SingleSelectionModel<T> selectionModel;
    protected ListDataProvider<T> dataProvider;

    public AbstractStaticTableWidget() {

        table = new CellTable<T>();
        initTableColumns();

        dataProvider = new ListDataProvider<T>();
        dataProvider.addDataDisplay(table);

        initWidget(table);
    }

    public @interface A{

    }

    protected abstract void initTableColumns();

    public void setValues(List<T> values) {
        dataProvider.setList(values);
        dataProvider.refresh();
    }

    public T getSelected() {
        return selectionModel.getSelectedObject();
    }

    public CellTable<T> getTable() {
        return table;
    }
}