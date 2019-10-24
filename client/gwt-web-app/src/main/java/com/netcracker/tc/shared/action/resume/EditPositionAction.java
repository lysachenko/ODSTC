package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.PositionDTO;

/**
 * Created by unconsionable on 15.07.2014.
 */
public class EditPositionAction extends UnsecuredActionImpl<NoResult> {

    private PositionDTO positionDTO;

    public EditPositionAction(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private EditPositionAction(){
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }
}