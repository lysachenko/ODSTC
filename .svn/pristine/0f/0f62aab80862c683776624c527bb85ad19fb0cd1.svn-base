package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.converter.ConverterUtil;
import com.netcracker.tc.server.persistence.dao.api.InterviewDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.interview.*;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.api.InterviewService;
import com.netcracker.tc.server.service.common.AbstractService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.interview.*;
import com.netcracker.tc.shared.model.user.PositionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class InterviewServiceImpl extends AbstractService implements InterviewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private InterviewDao interviewDao;

    public InterviewSlotDTO getActiveUserInterview(Long userId)
            throws ServiceException {
        User user = this.userDao.get(userId);
        if (user == null) {
            throw new ServiceException("Пользователя нету в системе");
        }
        InterviewSlot activeUserInterview = this.interviewDao.getActiveUserInterview(user);
        if (activeUserInterview != null) {
            return ConverterUtil.convertUserInterview(activeUserInterview);
        }
        return null;
    }

    public PagingLoadResultDTO<InterviewSlot> getInterviewSlots(PagingLoadConfigDTO pagingLoadConfig)
            throws ServiceException {
        return null;
    }

    public PagingLoadResultDTO<InterviewDTO> getInterviews(PagingLoadConfigDTO pagingLoadConfig)
            throws ServiceException {
        PagingLoadResult<Interview> result = this.interviewDao.loadInterviews(ConverterUtil.convert(pagingLoadConfig));

        return new PagingLoadResultDTO(ConverterUtil.convertInterviews(result.getItems()), result.getPageNumber(), result.getTotalItemCount());
    }

    public void addInterview(InterviewDTO interviewDTO)
            throws ServiceException {
        Interview interview = new Interview();
        interview.setInterviewDate(interviewDTO.getInterviewDate());
        interview.setPosition(this.userDao.getPosition(interviewDTO.getPosition().getId()));
        interview.setStartTime(interviewDTO.getStartTime());
        interview.setInterviewerTimeForInterview(interviewDTO.getInterviewerTimeForInterview());
        interview.setInterviewerCount(interviewDTO.getInterviewerCount());
        interview.setHrCount(interviewDTO.getHrCount());
        interview.setHrTimeForInterview(interviewDTO.getHrTimeForInterview());
        interview.setEnable(interviewDTO.getEnable());
        interview.setEndTime(interviewDTO.getEndTime());

        Set<InterviewSlot> interviewSlots = createInterviewSlots(interview);
        interview.setTotalPlaceCount(Integer.valueOf(interviewSlots.size()));
        interview.setAvailablePlaceCount(Integer.valueOf(interviewSlots.size()));

        this.interviewDao.create(interview);

        interview.setInterviewSlots(interviewSlots);
    }

    private Set<InterviewSlot> createInterviewSlots(Interview interview) {
        Set<InterviewSlot> interviewSlots = new HashSet();

        int interviewCount = 0;
        int timeForInterview = 0;
        if (interview.getHrTimeForInterview() / interview.getHrCount() > interview.getInterviewerTimeForInterview() / interview.getInterviewerCount()) {
            interviewCount = interview.getHrCount();
            timeForInterview = interview.getHrTimeForInterview();
        } else {
            interviewCount = interview.getInterviewerCount();
            timeForInterview = interview.getInterviewerTimeForInterview();
        }

        for (long startTime = interview.getStartTime(); startTime < interview.getEndTime(); startTime += timeForInterview * 60 * 1000) {
            for (int n = 0; n < interviewCount; n++) {
                InterviewSlot slot = new InterviewSlot();
                slot.setTime(Long.valueOf(startTime));
                slot.setInterview(interview);
                interviewSlots.add(slot);
            }
        }
        return interviewSlots;
    }

    public void editInterview(InterviewDTO interviewDTO)
            throws ServiceException {
    }

    public void deleteInterview(Long interviewId)
            throws ServiceException {
        Interview interview = interviewDao.get(interviewId);
        if (interview.getAvailablePlaceCount() != interview.getTotalPlaceCount()){
            throw new ServiceException("Нельзя удалить собеседование на которое уже подали заявки студенты");
        }

        this.interviewDao.deleteInterview(interviewId);
    }

    public void acceptInterview(Long userId, Long interviewId, long startTime)
            throws ServiceException {
        User user = this.userDao.get(userId);
        if (user == null) {
            throw new ServiceException("Пользователя нет в системе");
        }
        InterviewSlot activeUserInterview = this.interviewDao.getActiveUserInterview(user);
        if (activeUserInterview != null) {
            throw new ServiceException("У вас уже есть интервью");
        }
        Interview interview = this.interviewDao.get(interviewId);

        InterviewSlot availableInterviewSlot = this.interviewDao.getAvailableInterviewSlot(interview, startTime);
        if (availableInterviewSlot == null) {
            throw new ServiceException("Выбранное вами время недоступно");
        }
        availableInterviewSlot.setUser(user);
        interview.setAvailablePlaceCount(Integer.valueOf(interview.getAvailablePlaceCount().intValue() - 1));

        this.interviewDao.update(interview);

        user.getStudentDetail().setUserStatus(null);
        this.userDao.update(user);
    }

    public void cancelInterview(Long userId)
            throws ServiceException {
        User user = this.userDao.get(userId);

        InterviewSlot activeUserInterview = this.interviewDao.getActiveUserInterview(user);
        if (activeUserInterview == null) {
            throw new ServiceException("У вас нету активных собеседований");
        }
        activeUserInterview.setUser(null);
        Interview interview = activeUserInterview.getInterview();
        interview.setAvailablePlaceCount(Integer.valueOf(interview.getAvailablePlaceCount().intValue() + 1));

        this.interviewDao.update(interview);
    }

    public void activateInterview(Long interviewId, boolean activate)
            throws ServiceException {
        Interview interview = (Interview) this.interviewDao.get(interviewId);
        if (interview == null) {
            throw new ServiceException("Собеседования с id [" + interviewId + "] нету.");
        }
        interview.setEnable(Boolean.valueOf(activate));
        this.interviewDao.update(interview);
    }

    public List<InterviewDTO> getAvailableInterviews(PositionDTO positionDTO)
            throws ServiceException {
        return null;
    }

    public List<Long> getAvailableInterviewTimes(Long interviewId)
            throws ServiceException {
        return null;
    }

    public List<AvailableInterviewDTO> getAvailableInterviewList(PositionDTO positionDTO)
            throws ServiceException {
        List<Interview> availableInterviews = this.interviewDao.getAvailableInterviews(this.userDao.getPosition(positionDTO.getId()));

        List<AvailableInterviewDTO> availableInterviewList = new ArrayList();
        for (Interview interview : availableInterviews) {
            AvailableInterviewDTO availableInterviewDTO = new AvailableInterviewDTO();
            availableInterviewDTO.setInterview(ConverterUtil.convert(interview));

            List<Long> availableTimes = new ArrayList();
            List<InterviewSlot> interviewSlots = this.interviewDao.getAvailableInterviewSlots(interview);
            for (InterviewSlot interviewSlot : interviewSlots) {
                availableTimes.add(interviewSlot.getTime());
            }
            availableInterviewDTO.setInterviewTimeList(availableTimes);

            availableInterviewList.add(availableInterviewDTO);
        }
        return availableInterviewList;
    }

    public InterviewSlotDTO getLastUserInterview(Long userId) {
        LOGGER.info("GetLastUserInterview for: {}", userId);
        InterviewSlot lastUserInterview = this.interviewDao.getLastUserInterview(userId);
        if (lastUserInterview != null) {
            return ConverterUtil.convertUserInterview(lastUserInterview);
        }
        return null;
    }

    public InterviewResultDTO getInterviewResult(Long interviewSlotId) {
        InterviewResult result = this.interviewDao.getInterviewResult(interviewSlotId);
        if (result != null) {
            return ConverterUtil.convertInterviewResult(result);
        }
        return null;
    }

    public void editHRInterviewResult(InterviewResultDTO interviewResultDTO, Long hrUserId) throws ServiceException {
        DevInterviewResultDetailDTO devDetail = interviewResultDTO.getDevInterviewResultDetail();
        QAInterviewResultDetailDTO qaDetail = interviewResultDTO.getQaInterviewResultDetail();

        InterviewResult interviewResult = initInterviewResult(interviewResultDTO.getInterviewSlot().getId());

        User user = this.userDao.get(hrUserId);
        interviewResult.setHr(user);
        interviewResult.setIsCome(interviewResultDTO.getIsCome());

        if (devDetail != null) {
            DevInterviewResultDetail devInterviewResultDetail = interviewResult.getDevInterviewResultDetail();
            devInterviewResultDetail.setHrOtherInformation(devDetail.getHrOtherInformation());
            devInterviewResultDetail.setHrWorkWithUser(devDetail.getHrWorkWithUser());
            devInterviewResultDetail.setHrFinalAssessment(devDetail.getHrFinalAssessment());
        }

        if (qaDetail != null){
            QAInterviewResultDetail qaInterviewResultDetail = interviewResult.getQaInterviewResultDetail();
            qaInterviewResultDetail.setHrComeToInterview(qaDetail.getHrComeToInterview());
            qaInterviewResultDetail.setHrWorkWithUser(qaDetail.getHrWorkWithUser());
            qaInterviewResultDetail.setHrFinalAssessment(qaDetail.getHrFinalAssessment());
            qaInterviewResultDetail.setHrOtherInformation(qaDetail.getHrOtherInformation());
        }

        this.interviewDao.createOrUpdate(interviewResult);
    }

    public void editDEVInterviewResult(InterviewResultDTO interviewResultDTO, Long interviewUserId) throws ServiceException {
        DevInterviewResultDetailDTO devDetail = interviewResultDTO.getDevInterviewResultDetail();
        QAInterviewResultDetailDTO qaDetail = interviewResultDTO.getQaInterviewResultDetail();

        InterviewResult interviewResult = initInterviewResult(interviewResultDTO.getInterviewSlot().getId());

        User user = this.userDao.get(interviewUserId);
        interviewResult.setInterviewer(user);
        interviewResult.setIsCome(interviewResultDTO.getIsCome());

        if (devDetail != null) {
            DevInterviewResultDetail devInterviewResultDetail = interviewResult.getDevInterviewResultDetail();
            devInterviewResultDetail.setJavaSkill(devDetail.getJavaSkill());
            devInterviewResultDetail.setSqlSkill(devDetail.getSqlSkill());
            devInterviewResultDetail.setInterviewerOtherInformation(devDetail.getInterviewerOtherInformation());
            devInterviewResultDetail.setInterviewerWorkWithUser(devDetail.getInterviewerWorkWithUser());
            devInterviewResultDetail.setDevFinalAssessment(devDetail.getDevFinalAssessment());
        }

        if (qaDetail != null){
            QAInterviewResultDetail qaInterviewResultDetail = interviewResult.getQaInterviewResultDetail();
            qaInterviewResultDetail.setInterviewerBasicInformation(qaDetail.getInterviewerBasicInformation());
            qaInterviewResultDetail.setInterviewerWorkWithUser(qaDetail.getInterviewerWorkWithUser());
            qaInterviewResultDetail.setInterviewerOther(qaDetail.getInterviewerOther());
            qaInterviewResultDetail.setInterviewerFinalAssessment(qaDetail.getInterviewerFinalAssessment());
            qaInterviewResultDetail.setInterviewerComeToInterview(qaDetail.getInterviewerComeToInterview());
            qaInterviewResultDetail.setItKnowledge1(qaDetail.getItKnowledge1());
            qaInterviewResultDetail.setItKnowledge2(qaDetail.getItKnowledge2());
            qaInterviewResultDetail.setItKnowledge3(qaDetail.getItKnowledge3());
            qaInterviewResultDetail.setItKnowledge4(qaDetail.getItKnowledge4());
            qaInterviewResultDetail.setQaKnowledge1(qaDetail.getQaKnowledge1());
            qaInterviewResultDetail.setQaKnowledge2(qaDetail.getQaKnowledge2());
            qaInterviewResultDetail.setQaKnowledge3(qaDetail.getQaKnowledge3());
            qaInterviewResultDetail.setQaKnowledge4(qaDetail.getQaKnowledge4());
            qaInterviewResultDetail.setQaKnowledge5(qaDetail.getQaKnowledge5());
            qaInterviewResultDetail.setQaKnowledge6(qaDetail.getQaKnowledge6());
        }

        this.interviewDao.createOrUpdate(interviewResult);
    }

    private InterviewResult initInterviewResult(Long interviewSlotId) throws ServiceException {
        User user = interviewDao.getInterviewSlot(interviewSlotId).getUser();

        if (user.isArchive()){
            throw new ServiceException("Вы не можете отредактировать результаты собеседования архивного пользователя.");
        }

        InterviewResult interviewResult = this.interviewDao.getInterviewResult(interviewSlotId);

        if (interviewResult == null) {
            interviewResult = new InterviewResult();
            interviewResult.setDevInterviewResultDetail(new DevInterviewResultDetail());
            interviewResult.getDevInterviewResultDetail().setInterviewResult(interviewResult);
            interviewResult.setQaInterviewResultDetail(new QAInterviewResultDetail());
            interviewResult.getQaInterviewResultDetail().setInterviewResult(interviewResult);
            interviewResult.setInterviewSlotId(interviewSlotId);
            this.interviewDao.create(interviewResult);
        }

        return interviewResult;
    }
}
