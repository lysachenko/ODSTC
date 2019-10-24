package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

import java.util.List;

public class GetQAResumeResult implements Result {

    private ResumeDTO qaResumeDetailDTO;
    private List<InstituteDTO> instituteDTOList;
    private boolean isInterviewExist;

    public GetQAResumeResult(ResumeDTO qaResumeDetailDTO, List<InstituteDTO> instituteDTOList, boolean isInterviewExist) {
        this.qaResumeDetailDTO = qaResumeDetailDTO;
        this.instituteDTOList = instituteDTOList;
        this.isInterviewExist = isInterviewExist;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private GetQAResumeResult(){
    }

    public ResumeDTO getQaResumeDetailDTO() {
        return qaResumeDetailDTO;
    }

    public List<InstituteDTO> getInstituteDTOList() {
        return instituteDTOList;
    }

    public boolean isInterviewExist() {
        return isInterviewExist;
    }
}
