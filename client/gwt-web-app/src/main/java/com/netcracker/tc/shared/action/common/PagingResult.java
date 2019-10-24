package com.netcracker.tc.shared.action.common;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;

import java.io.Serializable;

/**
 * Created by unconsionable on 20.06.2014.
 */
public class PagingResult<T extends Serializable> implements Result {

    protected PagingLoadResultDTO<T> pagingLoadResult;

    public PagingResult(PagingLoadResultDTO<T> pagingLoadResult) {
        this.pagingLoadResult = pagingLoadResult;
    }

    public PagingResult() {
    }

    public PagingLoadResultDTO<T> getPagingLoadResult() {
        return pagingLoadResult;
    }
}
