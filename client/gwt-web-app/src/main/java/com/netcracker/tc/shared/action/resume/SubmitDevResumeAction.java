package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

public class SubmitDevResumeAction extends UnsecuredActionImpl<NoResult> {

    private ResumeDTO devResumeDetailDTO;

    public SubmitDevResumeAction(ResumeDTO devResumeDetailDTO) {
        this.devResumeDetailDTO = devResumeDetailDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private SubmitDevResumeAction(){
    }

    public ResumeDTO getResumeDTO() {
        return devResumeDetailDTO;
    }
}
