package com.netcracker.tc.shared.action.common;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;

import java.io.Serializable;

/**
 * Created by unconsionable on 20.06.2014.
 */
public class PagingActon<T extends Serializable, R extends PagingResult<T>> extends UnsecuredActionImpl<R> {

    protected PagingLoadConfigDTO pagingLoadConfig;

    public PagingActon(PagingLoadConfigDTO pagingLoadConfig){
        this.pagingLoadConfig = pagingLoadConfig;
    }

    public PagingActon(){
    }

    public PagingLoadConfigDTO getPagingLoadConfig() {
        return pagingLoadConfig;
    }
}
