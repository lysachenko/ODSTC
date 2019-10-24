package com.netcracker.tc.server.dispatch.interview;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.action.interview.GetUserInformationAction;
import com.netcracker.tc.shared.action.interview.GetUserInformationResult;
import com.netcracker.tc.shared.action.interview.GetUserInterviewAction;
import com.netcracker.tc.shared.action.interview.GetUserInterviewResult;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserInformationHandler extends AbstractActionHandler<GetUserInformationAction, GetUserInformationResult> {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;

    public GetUserInformationHandler() {
    }

    @Override
    protected GetUserInformationResult process(GetUserInformationAction action, ExecutionContext context) throws ServiceException, ActionException {
        Long userId = action.getUserId();

        GetUserInformationResult result = new GetUserInformationResult();

        PositionDTO position = userService.getUser(userId).getStudentDetail().getPosition();
        InterviewSlotDTO interviewSlot = interviewService.getLastUserInterview(userId);
        if (interviewSlot != null) {
            result.setInterviewResultDTO(interviewService.getInterviewResult(interviewSlot.getId()));
        }
        if (position != null) {
            if (position.isDev()) {
                result.setResume(resumeService.getDevResume(userId));
            } else {
                result.setResume(resumeService.getQAResume(userId));
            }
        }
        result.setPositionDTO(position);
        result.setInstituteDTOList(resumeService.getInstitutes());
        result.setKnowledgeTypeDTOList(resumeService.getKnowledgeTypes());
        result.setInterviewSlot(interviewSlot);
        result.setArchiveUser(userService.isArchiveUser(userId));

        return result;
    }

    @Override
    public Class<GetUserInformationAction> getActionType() {
        return GetUserInformationAction.class;
    }
}