package com.netcracker.tc.shared.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by unconsionable on 20.06.2014.
 */
public class PagingLoadResultDTO<T extends Serializable> implements Serializable {

    private List<T> items;
    private int pageNumber;
    private int totalItemCount;

    public PagingLoadResultDTO(List<T> items, int pageNumber, int totalPageCount) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.totalItemCount = totalPageCount;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private PagingLoadResultDTO(){
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
}