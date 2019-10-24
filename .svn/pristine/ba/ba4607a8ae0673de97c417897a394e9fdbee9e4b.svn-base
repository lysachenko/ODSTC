package com.netcracker.tc.client.ui.widget.common;

import com.github.gwtbootstrap.client.ui.DataGrid;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractAsyncTableWidget<T extends Serializable> extends Composite {

    protected CellTable<T> table;
    protected SelectionModel<T> selectionModel;
    protected SimplePager pager;
    protected AsyncDataProvider<T> dataProvider;

    public AbstractAsyncTableWidget() {
        table = new CellTable<T>();
        initTableColumns();
        initSelectionModel();
        initPager();

        VerticalPanel vp = new VerticalPanel();
        vp.add(table);
        vp.add(pager);
        pager.setPageSize(25);

        initWidget(vp);
    }

    protected abstract void initTableColumns();

    protected void initSelectionModel() {
        selectionModel = new SingleSelectionModel<T>();
        table.setSelectionModel(selectionModel);
    }

    private void initPager() {
        pager = new SimplePager();
        pager.setDisplay(table);
        pager.setRangeLimited(true);
    }

    public void setValues(PagingLoadResultDTO<T> loadResult) {
        pager.setPageStart(loadResult.getPageNumber());
        dataProvider.updateRowData(loadResult.getPageNumber(), loadResult.getItems());
        dataProvider.updateRowCount(loadResult.getTotalItemCount(), true);
    }

    public void setValues(List<T> values) {
        dataProvider.updateRowData(0, values);
        dataProvider.updateRowCount(values.size(), true);
    }

    public T getSelected() {
        if (selectionModel instanceof SingleSelectionModel) {
            return ((SingleSelectionModel<T>) selectionModel).getSelectedObject();
        }

        return null;
    }

    public void setDataProvider(AsyncDataProvider<T> dataProvider) {
        this.dataProvider = dataProvider;
        dataProvider.addDataDisplay(table);
    }

    public PagingLoadConfigDTO getPagingLoadConfig() {
        return new PagingLoadConfigDTO(pager.getPage(), pager.getPageSize());
    }

    public void addSelectionHandler(SelectionChangeEvent.Handler handler){
        selectionModel.addSelectionChangeHandler(handler);
    }
}
