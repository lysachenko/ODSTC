package com.netcracker.tc.shared.model.common;

import java.io.Serializable;

public class PagingLoadConfigDTO implements Serializable {

    private int pageNumber;
    private int pageSize;

    public PagingLoadConfigDTO(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private PagingLoadConfigDTO(){
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "PageNumber: " + pageNumber +", PageSize: " + pageSize;
    }
}