package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.PositionDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class GetAvailableInterviewAction extends UnsecuredActionImpl<GetAvailableInterviewResult> {

    private PositionDTO positionDTO;

    public GetAvailableInterviewAction(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    /**
     * For serialization onl    y
     */
    @SuppressWarnings("unused")
    private GetAvailableInterviewAction(){
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }
}