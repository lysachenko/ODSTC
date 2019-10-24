package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.interview.AvailableInterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.user.PositionDTO;

import java.util.Date;
import java.util.List;

public interface InterviewService {

    public InterviewSlotDTO getActiveUserInterview(Long userId) throws ServiceException;

    PagingLoadResultDTO<InterviewSlot> getInterviewSlots(PagingLoadConfigDTO pagingLoadConfig) throws ServiceException;

    PagingLoadResultDTO<InterviewDTO> getInterviews(PagingLoadConfigDTO pagingLoadConfig) throws ServiceException;

    void addInterview(InterviewDTO interviewDTO) throws ServiceException;

    void editInterview(InterviewDTO interviewDTO) throws ServiceException;

    void deleteInterview(Long interviewId) throws ServiceException;

    void acceptInterview(Long userId, Long interviewId, long startTime) throws ServiceException;

    void cancelInterview(Long userId) throws ServiceException;

    void activateInterview(Long interviewId, boolean activate) throws ServiceException;

    List<InterviewDTO> getAvailableInterviews(PositionDTO positionDTO) throws ServiceException;

    List<Long> getAvailableInterviewTimes(Long interviewId) throws ServiceException;

    List<AvailableInterviewDTO> getAvailableInterviewList(PositionDTO positionDTO) throws ServiceException;

    InterviewSlotDTO getLastUserInterview(Long userId);

    InterviewResultDTO getInterviewResult(Long userId);

    void editHRInterviewResult(InterviewResultDTO interviewResultDTO, Long hrUserId) throws ServiceException;

    void editDEVInterviewResult(InterviewResultDTO interviewResultDTO, Long interviewUserId) throws ServiceException;
}