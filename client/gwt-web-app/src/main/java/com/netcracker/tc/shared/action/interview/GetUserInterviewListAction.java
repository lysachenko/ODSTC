package com.netcracker.tc.shared.action.interview;

import com.netcracker.tc.shared.action.common.PagingActon;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

public class GetUserInterviewListAction extends PagingActon<InterviewSlotDTO, GetInterviewSlotListResult> {

    public GetUserInterviewListAction(PagingLoadConfigDTO pagingLoadConfig) {
        super(pagingLoadConfig);
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private GetUserInterviewListAction() {
    }
}
