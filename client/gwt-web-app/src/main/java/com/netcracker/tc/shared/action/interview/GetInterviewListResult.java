package com.netcracker.tc.shared.action.interview;

import com.netcracker.tc.shared.action.common.PagingResult;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewDTO;

public class GetInterviewListResult extends PagingResult<InterviewDTO>{

    public GetInterviewListResult(PagingLoadResultDTO<InterviewDTO> pagingLoadResult) {
        super(pagingLoadResult);
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private GetInterviewListResult() {
    }
}