package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;

import java.util.List;

/**
 * Created by Admin on 13.07.14.
 */
public class GetAvailableInterviewResult implements Result {

    private List<AvailableInterviewDTO> availableInterviewDTOList;

    public GetAvailableInterviewResult(List<AvailableInterviewDTO> availableInterviewDTOList) {
        this.availableInterviewDTOList = availableInterviewDTOList;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private GetAvailableInterviewResult(){
    }

    public List<AvailableInterviewDTO> getAvailableInterviewDTOList() {
        return availableInterviewDTOList;
    }
}