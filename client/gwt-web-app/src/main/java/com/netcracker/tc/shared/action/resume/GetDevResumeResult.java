package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.Result;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

import java.util.List;

/**
 * Created by Admin on 13.07.14.
 */
public class GetDevResumeResult implements Result {

    private ResumeDTO resume;
    private List<InstituteDTO> instituteDTOList;
    private List<KnowledgeTypeDTO> knowledgeTypeDTOList;
    private boolean isInterviewExist;

    public GetDevResumeResult(ResumeDTO resume, List<InstituteDTO> instituteDTOList,
                              List<KnowledgeTypeDTO> knowledgeTypeDTOList, boolean isInterviewExist) {
        this.resume = resume;
        this.instituteDTOList = instituteDTOList;
        this.knowledgeTypeDTOList = knowledgeTypeDTOList;
        this.isInterviewExist = isInterviewExist;
    }

    @SuppressWarnings("unused")
    private GetDevResumeResult(){
    }

    public List<InstituteDTO> getInstituteDTOList() {
        return instituteDTOList;
    }

    public ResumeDTO getResume() {
        return resume;
    }

    public List<KnowledgeTypeDTO> getKnowledgeTypeDTOList() {
        return knowledgeTypeDTOList;
    }

    public boolean isInterviewExist() {
        return isInterviewExist;
    }
}