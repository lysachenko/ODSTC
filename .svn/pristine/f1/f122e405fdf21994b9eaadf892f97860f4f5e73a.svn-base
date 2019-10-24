package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

public class CreateDevResumeAction extends UnsecuredActionImpl<IsDevResumeValid> {



    private ResumeDTO devResumeDetailDTO;

    public CreateDevResumeAction(ResumeDTO devResumeDetailDTO) {
        this.devResumeDetailDTO = devResumeDetailDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private CreateDevResumeAction(){
    }

    public ResumeDTO getResumeDTO() {
        return devResumeDetailDTO;
    }
}