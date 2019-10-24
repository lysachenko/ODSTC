package com.netcracker.tc.server.persistence.dao.api;

import com.netcracker.tc.server.persistence.dao.common.IDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.interview.Interview;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.user.Position;
import com.netcracker.tc.server.persistence.model.user.User;

import java.util.List;
import java.util.Set;

/**
 * Created by unconsionable on 28.07.2014.
 */
public interface InterviewDao extends IDao<Interview, Long> {

    PagingLoadResult<Interview> loadInterviews(PagingLoadConfig loadConfig);

    void createInterviewSlots(InterviewSlot interviewSlot);

    void persist(Interview interview);

    List<Interview> getAvailableInterviews(Position position);

    InterviewSlot getAvailableInterviewSlot(Interview interviewId, long startTime);

    void update(InterviewSlot availableInterviewSlot);

    InterviewSlot getActiveUserInterview(User user);

    List<InterviewSlot> getAvailableInterviewSlots(Interview interview);

    List<InterviewSlot> getUserInterviewSlots();

    InterviewSlot getLastUserInterview(Long userId);

    InterviewResult getInterviewResult(Long interviewSlotId);

    void createOrUpdate(InterviewResult interviewResult);

    void create(InterviewResult interviewResult);

    InterviewSlot getInterviewSlot(Long slotId);

    void deleteInterview(Long interviewId);
}