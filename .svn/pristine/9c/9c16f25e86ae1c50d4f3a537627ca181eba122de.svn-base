package com.netcracker.tc.server.dispatch.resume;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.resume.GetQAResumeAction;
import com.netcracker.tc.shared.action.resume.GetQAResumeResult;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetQAResumeHandler extends AbstractActionHandler<GetQAResumeAction, GetQAResumeResult> {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private InterviewService interviewService;

    public GetQAResumeHandler() {
    }

    @Override
    protected GetQAResumeResult process(GetQAResumeAction action, ExecutionContext
            context) throws ServiceException, ActionException {
        Long userId = Session.getUserId();

        ResumeDTO resume = resumeService.getQAResume(userId);
        List<InstituteDTO> institutes = resumeService.getInstitutes();
        InterviewSlotDTO activeUserInterview = interviewService.getActiveUserInterview(userId);

        return new GetQAResumeResult(resume, institutes, activeUserInterview != null);
    }

    @Override
    public Class<GetQAResumeAction> getActionType() {
        return GetQAResumeAction.class;
    }
}
