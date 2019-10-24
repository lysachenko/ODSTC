package com.netcracker.tc.server.persistence.model.common;

import java.io.Serializable;

public class PagingLoadConfig implements Serializable {

    private int pageNumber;
    private int pageSize;

    public PagingLoadConfig(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private PagingLoadConfig(){
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
