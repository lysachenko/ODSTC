package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

/**
 * Created by Admin on 13.07.14.
 */
public class EditDevResumeAction extends UnsecuredActionImpl<NoResult> {

    private ResumeDTO devResumeDetailDTO;

    public EditDevResumeAction(ResumeDTO devResumeDetailDTO) {
        this.devResumeDetailDTO = devResumeDetailDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private EditDevResumeAction(){
    }

    public ResumeDTO getResumeDTO() {
        return devResumeDetailDTO;
    }
}