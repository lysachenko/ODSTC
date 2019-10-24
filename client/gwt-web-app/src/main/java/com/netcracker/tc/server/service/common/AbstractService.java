package com.netcracker.tc.server.service.common;

import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unconsionable on 20.06.2014.
 */
public class AbstractService {

    protected <T extends Serializable> PagingLoadResultDTO<T> loadPagingData(List<T> allData, PagingLoadConfigDTO pagingLoadConfig){
        int pageSize = pagingLoadConfig.getPageSize();
        int pageNumber = pagingLoadConfig.getPageNumber();

        int dataPageCount = allData.size() / pageSize;

        pageNumber = pageNumber <= dataPageCount ? pageNumber : dataPageCount;

        int fromRange = pageNumber * pageSize;
        int toRange = Math.min(fromRange + pageSize, allData.size());

        return new PagingLoadResultDTO<T>(new ArrayList<T>(allData.subList(fromRange, toRange)), fromRange, allData.size());
    }
}