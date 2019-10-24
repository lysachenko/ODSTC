package com.netcracker.tc.server.persistence.model.common;

import java.io.Serializable;
import java.util.List;

public class PagingLoadResult<T> implements Serializable {

    protected List<T> items;
    protected int pageNumber;
    protected int totalItemCount;

    public PagingLoadResult(List<T> items, int pageNumber, int totalPageCount) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.totalItemCount = totalPageCount;
    }

    public PagingLoadResult(){
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    @Override
    public String toString() {
        return "PageNumber: " + pageNumber + ", TotalItemCount: " + totalItemCount + ", itemsCount: " + items.size();
    }
}
