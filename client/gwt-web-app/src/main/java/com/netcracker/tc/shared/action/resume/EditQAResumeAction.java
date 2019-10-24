package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

/**
 * Created by unconsionable on 23.07.2014.
 */
public class EditQAResumeAction extends UnsecuredActionImpl<NoResult> {

    private ResumeDTO qaResumeDetailDTO;

    public EditQAResumeAction(ResumeDTO qaResumeDetailDTO) {
        this.qaResumeDetailDTO = qaResumeDetailDTO;
    }

    @SuppressWarnings("unused")
    private EditQAResumeAction(){
    }

    public ResumeDTO getQaResumeDetailDTO() {
        return qaResumeDetailDTO;
    }
}
