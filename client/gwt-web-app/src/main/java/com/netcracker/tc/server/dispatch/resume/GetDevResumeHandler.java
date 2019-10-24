package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.GetDevResumeAction;
import com.netcracker.tc.shared.action.resume.GetDevResumeResult;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDevResumeHandler extends AbstractActionHandler<GetDevResumeAction, GetDevResumeResult> {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private InterviewService interviewService;

    public GetDevResumeHandler() {
    }

    @Override
    protected GetDevResumeResult process(GetDevResumeAction action, ExecutionContext
            context) throws ServiceException, ActionException {
        Long userId = Session.getExistUserId();

        ResumeDTO resume = resumeService.getDevResume(userId);
        List<InstituteDTO> institutes = resumeService.getInstitutes();
        List<KnowledgeTypeDTO> knowledgeTypes = resumeService.getKnowledgeTypes();
        InterviewSlotDTO activeUserInterview = interviewService.getActiveUserInterview(userId);

        return new GetDevResumeResult(resume, institutes, knowledgeTypes, activeUserInterview != null);
    }

    @Override
    public Class<GetDevResumeAction> getActionType() {
        return GetDevResumeAction.class;
    }
}