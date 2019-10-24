package com.netcracker.tc.server.converter;

import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.interview.*;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;
import com.netcracker.tc.server.persistence.model.resume.*;
import com.netcracker.tc.server.persistence.model.user.*;
import com.netcracker.tc.server.util.DateUtil;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.interview.*;
import com.netcracker.tc.shared.model.resume.*;
import com.netcracker.tc.shared.model.user.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ConverterUtil
{
    public static UserDTO convert(User user)
    {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setInterviewSlots(convert(user.getInterviewSlots()));
        userDTO.setLastLoginDate(user.getLastLoginDate());
        userDTO.setLogin(user.getLogin());
        userDTO.setResume(convert(user.getResume()));
        userDTO.setStudentDetail(convert(user.getStudentDetail()));
        userDTO.setRole(convert(user.getRole()));
        return userDTO;
    }

    public static Set<InterviewSlotDTO> convert(Set<InterviewSlot> interviewSlots)
    {
        return null;
    }

    public static ResumeDTO convert(Resume resume)
    {
        if (resume == null) {
            return null;
        }
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setId(resume.getId());
        resumeDTO.setApprovedDate(resume.getApprovedDate());
        resumeDTO.setName(resume.getName());
        resumeDTO.setSurname(resume.getSurname());
        resumeDTO.setLastName(resume.getLastName());
        resumeDTO.setEngName(resume.getEngName());
        resumeDTO.setEngSurname(resume.getEngSurname());
        resumeDTO.setSkype(resume.getSkype());
        resumeDTO.setPhotoPath(resume.getPhotoPath());
        resumeDTO.setTelephoneNum(resume.getTelephoneNum());
        resumeDTO.setEmail(resume.getEmail());
        resumeDTO.setDevResumeDetail(convert(resume.getDevResumeDetail()));
        resumeDTO.setQaResumeDetail(convert(resume.getQaResumeDetail()));



        return resumeDTO;
    }

    public static List<ResumeKnowledgeDTO> convertResumeKnowledges(Collection<ResumeKnowledge> resumeKnowledges)
    {
        List<ResumeKnowledgeDTO> resumeKnowledgeDTOs = new ArrayList();
        for (ResumeKnowledge resumeKnowledge : resumeKnowledges) {
            resumeKnowledgeDTOs.add(convert(resumeKnowledge));
        }
        return resumeKnowledgeDTOs;
    }

    private static ResumeKnowledgeDTO convert(ResumeKnowledge resumeKnowledge)
    {
        ResumeKnowledgeDTO resumeKnowledgeDTO = new ResumeKnowledgeDTO();

        resumeKnowledgeDTO.setKnowledgeLevel(resumeKnowledge.getKnowledgeLevel());
        resumeKnowledgeDTO.setKnowledgeType(convert(resumeKnowledge.getKnowledgeType()));

        return resumeKnowledgeDTO;
    }

    public static DevResumeDetailDTO convert(DevResumeDetail devResumeDetail)
    {
        if (devResumeDetail == null) {
            return null;
        }
        DevResumeDetailDTO devResumeDetailDTO = new DevResumeDetailDTO();

        devResumeDetailDTO.setInstituteOtherName(devResumeDetail.getInstituteOtherName());
        devResumeDetailDTO.setDepartment(devResumeDetail.getDepartment());
        devResumeDetailDTO.setSpecialty(devResumeDetail.getSpecialty());
        devResumeDetailDTO.setTrainingCenterInterest(devResumeDetail.getTrainingCenterInterest());
        devResumeDetailDTO.setWorkInNetCrackerInterest(devResumeDetail.getWorkInNetCrackerInterest());
        devResumeDetailDTO.setOtherJobInterests(devResumeDetail.getOtherJobInterests());
        devResumeDetailDTO.setBackEndInterest(devResumeDetail.getBackEndInterest());
        devResumeDetailDTO.setFrontEndInterest(devResumeDetail.getFrontEndInterest());
        devResumeDetailDTO.setDbInterest(devResumeDetail.getDbInterest());
        devResumeDetailDTO.setOtherWorkTypeSpecific(devResumeDetail.getOtherWorkTypeSpecific());
        devResumeDetailDTO.setOOPLevel(devResumeDetail.getOOPLevel());
        devResumeDetailDTO.setDbLevel(devResumeDetail.getDbLevel());
        devResumeDetailDTO.setWebLevel(devResumeDetail.getWebLevel());
        devResumeDetailDTO.setUserInterfaceLevel(devResumeDetail.getUserInterfaceLevel());
        devResumeDetailDTO.setUmlLevel(devResumeDetail.getUmlLevel());
        devResumeDetailDTO.setOtherSkillsLevel(devResumeDetail.getOtherSkillsLevel());
        devResumeDetailDTO.setWorkExperience(devResumeDetail.getWorkExperience());
        devResumeDetailDTO.setEnglishReadLevel(devResumeDetail.getEnglishReadLevel());
        devResumeDetailDTO.setEnglishSpeakLevel(devResumeDetail.getEnglishSpeakLevel());
        devResumeDetailDTO.setEnglishWriteLevel(devResumeDetail.getEnglishWriteLevel());
        devResumeDetailDTO.setWhereYouKnowAboutTC(devResumeDetail.getWhereYouKnowAboutTC());
        devResumeDetailDTO.setWhyTakeYouInNetCracker(devResumeDetail.getWhyTakeYouInNetCracker());
        devResumeDetailDTO.setMoreInformationAboutYou(devResumeDetail.getMoreInformationAboutYou());
        devResumeDetailDTO.setCourse(devResumeDetail.getCourse());
        devResumeDetailDTO.setFaculty(devResumeDetail.getFaculty());
        devResumeDetailDTO.setGraduationYear(devResumeDetail.getGraduationYear());
        devResumeDetailDTO.setOtherContacts(devResumeDetail.getOtherContacts());
        devResumeDetailDTO.setInstitute(convert(devResumeDetail.getInstitute()));

        return devResumeDetailDTO;
    }

    public static QAResumeDetailDTO convert(QAResumeDetail qaResumeDetail)
    {
        if (qaResumeDetail == null) {
            return null;
        }
        QAResumeDetailDTO qaResumeDetailDTO = new QAResumeDetailDTO();

        qaResumeDetailDTO.setInstitute(convert(qaResumeDetail.getInstitute()));
        qaResumeDetailDTO.setInstituteOtherName(qaResumeDetail.getInstituteOtherName());
        qaResumeDetailDTO.setCourse(qaResumeDetail.getCourse());
        qaResumeDetailDTO.setFaculty(qaResumeDetail.getFaculty());
        qaResumeDetailDTO.setGraduationYear(qaResumeDetail.getGraduationYear());
        qaResumeDetailDTO.setIsStudent(qaResumeDetail.getIsStudent());
        qaResumeDetailDTO.setOtherContacts(qaResumeDetail.getOtherContacts());
        qaResumeDetailDTO.setTrainingCenterInterest(qaResumeDetail.getTrainingCenterInterest());
        qaResumeDetailDTO.setWorkInNetCrackerInterest(qaResumeDetail.getWorkInNetCrackerInterest());
        qaResumeDetailDTO.setOtherInterests(qaResumeDetail.getOtherInterests());
        qaResumeDetailDTO.setQaDevelopment(qaResumeDetail.getQaDevelopment());
        qaResumeDetailDTO.setSoftwareDevelopment(qaResumeDetail.getSoftwareDevelopment());
        qaResumeDetailDTO.setOtherJobInterests(qaResumeDetail.getOtherJobInterests());
        qaResumeDetailDTO.setQaExpertWorkType(qaResumeDetail.getQaExpertWorkType());
        qaResumeDetailDTO.setQaAutomationWorkType(qaResumeDetail.getQaAutomationWorkType());
        qaResumeDetailDTO.setQaDevelopmentWorkType(qaResumeDetail.getQaDevelopmentWorkType());
        qaResumeDetailDTO.setSoftwareDevelopmentWorkType(qaResumeDetail.getSoftwareDevelopmentWorkType());
        qaResumeDetailDTO.setLeadershipWorkType(qaResumeDetail.getLeadershipWorkType());
        qaResumeDetailDTO.setOtherWorkTypeSpecific(qaResumeDetail.getOtherWorkTypeSpecific());

        qaResumeDetailDTO.setSoftwareDevLifeCycle(qaResumeDetail.getSoftwareDevLifeCycle());
        qaResumeDetailDTO.setQaRoleInLifeCycle(qaResumeDetail.getQaRoleInLifeCycle());
        qaResumeDetailDTO.setWhatIsTestCase(qaResumeDetail.getWhatIsTestCase());
        qaResumeDetailDTO.setWhatIsDefect(qaResumeDetail.getWhatIsDefect());
        qaResumeDetailDTO.setTestingType(qaResumeDetail.getTestingType());
        qaResumeDetailDTO.setNetworkTechnology(qaResumeDetail.getNetworkTechnology());
        qaResumeDetailDTO.setOOP(qaResumeDetail.getOOP());
        qaResumeDetailDTO.setDbSql(qaResumeDetail.getDbSql());
        qaResumeDetailDTO.setClientServerArchitectureAndWeb(qaResumeDetail.getClientServerArchitectureAndWeb());

        qaResumeDetailDTO.setOtherSkillsLevel(qaResumeDetail.getOtherSkillsLevel());
        qaResumeDetailDTO.setWorkExperience(qaResumeDetail.getWorkExperience());
        qaResumeDetailDTO.setEnglishReadLevel(qaResumeDetail.getEnglishReadLevel());
        qaResumeDetailDTO.setEnglishSpeakLevel(qaResumeDetail.getEnglishSpeakLevel());
        qaResumeDetailDTO.setEnglishWriteLevel(qaResumeDetail.getEnglishWriteLevel());
        qaResumeDetailDTO.setWhereYouKnowAboutTC(qaResumeDetail.getWhereYouKnowAboutTC());
        qaResumeDetailDTO.setWhyTakeYouInNetCracker(qaResumeDetail.getWhyTakeYouInNetCracker());
        qaResumeDetailDTO.setMoreInformationAboutYou(qaResumeDetail.getMoreInformationAboutYou());

        return qaResumeDetailDTO;
    }

    public static StudentDetailDTO convert(StudentDetail studentDetail)
    {
        if (studentDetail == null) {
            return null;
        }
        StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
        studentDetailDTO.setId(studentDetail.getId());
        studentDetailDTO.setPosition(convert(studentDetail.getPosition()));
        studentDetailDTO.setUserStatus(convert(studentDetail.getUserStatus()));



        return studentDetailDTO;
    }

    public static UserStatusDTO convert(UserStatus userStatus)
    {
        if (userStatus == null) {
            return null;
        }
        UserStatusDTO userStatusDTO = new UserStatusDTO();
        userStatusDTO.setId(userStatus.getId().longValue());
        userStatusDTO.setDescription(userStatus.getDescription());
        return userStatusDTO;
    }

    public static PositionDTO convert(Position position)
    {
        if (position == null) {
            return null;
        }
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setDescription(position.getDescription());
        return positionDTO;
    }

    public static RoleDTO convert(Role role)
    {
        if (role == null) {
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setDescription(role.getDescription());
        return roleDTO;
    }

    public static List<UserDTO> convertUsers(List<User> items)
    {
        List<UserDTO> userList = new ArrayList();
        for (User user : items) {
            userList.add(convert(user));
        }
        return userList;
    }

    public static List<MailDTO> convertMails(List<MailQueue> items)
    {
        List<MailDTO> mailList = new ArrayList();
        for (MailQueue mail : items) {
            mailList.add(convert(mail));
        }
        return mailList;
    }

    private static MailDTO convert(MailQueue mail) {
        if (mail == null) {
            return null;
        }
        MailDTO mailDTO = new MailDTO();
        mailDTO.setSent(mail.getIsSent());
        mailDTO.setReceiverAddress(mail.getReceiverAddress());
        mailDTO.setReceiverSubject(mail.getMessageSubject());
        mailDTO.setReceiverBody(mail.getMessageBody());
        mailDTO.setAddedDate(mail.getAddedWhen());
        return mailDTO;

    }

    public static PagingLoadConfig convert(PagingLoadConfigDTO loadConfig)
    {
        return new PagingLoadConfig(loadConfig.getPageNumber(), loadConfig.getPageSize());
    }

    public static List<InterviewDTO> convertInterviews(List<Interview> items)
    {
        List<InterviewDTO> interviewList = new ArrayList();
        for (Interview interview : items) {
            interviewList.add(convert(interview));
        }
        return interviewList;
    }

    public static InterviewDTO convert(Interview interview)
    {
        InterviewDTO interviewDTO = new InterviewDTO();

        interviewDTO.setAvailablePlaceCount(interview.getAvailablePlaceCount());
        interviewDTO.setEnable(interview.getEnable());
        interviewDTO.setEndTime(interview.getEndTime());
        interviewDTO.setHrCount(interview.getHrCount());
        interviewDTO.setHrTimeForInterview(interview.getHrTimeForInterview());
        interviewDTO.setId(interview.getId());
        interviewDTO.setInterviewDate(DateUtil.toUserTimezone(interview.getInterviewDate()));
        interviewDTO.setInterviewerCount(interview.getInterviewerCount());
        interviewDTO.setInterviewerTimeForInterview(interview.getInterviewerTimeForInterview());
        interviewDTO.setTotalPlaceCount(interview.getTotalPlaceCount());
        interviewDTO.setStartTime(interview.getStartTime());
        interviewDTO.setPosition(convert(interview.getPosition()));

        return interviewDTO;
    }

    public static List<InstituteDTO> convertInstitutes(List<Institute> institutes)
    {
        List<InstituteDTO> result = new ArrayList();
        for (Institute institute : institutes) {
            result.add(convert(institute));
        }
        return result;
    }

    private static InstituteDTO convert(Institute institute)
    {
        InstituteDTO instituteDTO = new InstituteDTO();

        instituteDTO.setDescription(institute.getDescription());
        instituteDTO.setId(institute.getId());

        return instituteDTO;
    }

    public static List<KnowledgeTypeDTO> convertKnowledgeTypes(List<KnowledgeType> knowledgeTypes)
    {
        List<KnowledgeTypeDTO> result = new ArrayList();
        for (KnowledgeType knowledgeType : knowledgeTypes) {
            result.add(convert(knowledgeType));
        }
        return result;
    }

    private static KnowledgeTypeDTO convert(KnowledgeType knowledgeType)
    {
        KnowledgeTypeDTO dto = new KnowledgeTypeDTO();

        dto.setDescription(knowledgeType.getDescription());
        dto.setId(knowledgeType.getId());

        return dto;
    }

    public static InterviewSlotDTO convertUserInterview(InterviewSlot activeUserInterview)
    {
        InterviewSlotDTO result = new InterviewSlotDTO();

        result.setId(activeUserInterview.getId());
        result.setTime(activeUserInterview.getTime());

        InterviewDTO interviewDTO = new InterviewDTO();
        interviewDTO.setInterviewDate(DateUtil.toUserTimezone(activeUserInterview.getInterview().getInterviewDate()));

        result.setInterview(interviewDTO);

        return result;
    }

    public static UserPagingFilter convert(UserPagingFilterDTO filter)
    {
        UserPagingFilter result = new UserPagingFilter();

        result.setRoleId(filter.getRoleId());
        result.setEmail(filter.getEmail());
        result.setName(filter.getName());
        result.setTelephone(filter.getTelephone());
        result.setDevResultInterview(filter.getDevResultInterview());
        result.setHrResultInterview(filter.getHrResultInterview());
        result.setPositionId(filter.getPositionId());
        result.setUsedStatusId(filter.getUserStatusId());

        return result;
    }

    public static InterviewResultDTO convertInterviewResult(InterviewResult result)
    {
        InterviewResultDTO resultDTO = new InterviewResultDTO();
        if (result.getHr() != null) {
            resultDTO.setHr(result.getHr().getLogin());
        }
        if (result.getInterviewer() != null) {
            resultDTO.setInterviewer(result.getInterviewer().getLogin());
        }
        resultDTO.setIsCome(result.getIsCome());
        resultDTO.setDevInterviewResultDetail(convert(result.getDevInterviewResultDetail()));
        resultDTO.setQaInterviewResultDetail(convert(result.getQaInterviewResultDetail()));

        return resultDTO;
    }

    private static QAInterviewResultDetailDTO convert(QAInterviewResultDetail qaInterviewResultDetail) {
        QAInterviewResultDetailDTO result = new QAInterviewResultDetailDTO();

        if (qaInterviewResultDetail == null){
            return null;
        }

        result.setHrComeToInterview(qaInterviewResultDetail.getHrComeToInterview());
        result.setHrFinalAssessment(qaInterviewResultDetail.getHrFinalAssessment());
        result.setHrOtherInformation(qaInterviewResultDetail.getHrOtherInformation());
        result.setHrWorkWithUser(qaInterviewResultDetail.getHrWorkWithUser());
        result.setInterviewerBasicInformation(qaInterviewResultDetail.getInterviewerBasicInformation());
        result.setInterviewerComeToInterview(qaInterviewResultDetail.getInterviewerComeToInterview());
        result.setInterviewerFinalAssessment(qaInterviewResultDetail.getInterviewerFinalAssessment());
        result.setInterviewerOther(qaInterviewResultDetail.getInterviewerOther());
        result.setInterviewerWorkWithUser(qaInterviewResultDetail.getInterviewerWorkWithUser());
        result.setItKnowledge1(qaInterviewResultDetail.getItKnowledge1());
        result.setItKnowledge2(qaInterviewResultDetail.getItKnowledge2());
        result.setItKnowledge3(qaInterviewResultDetail.getItKnowledge3());
        result.setItKnowledge4(qaInterviewResultDetail.getItKnowledge4());
        result.setQaKnowledge1(qaInterviewResultDetail.getQaKnowledge1());
        result.setQaKnowledge2(qaInterviewResultDetail.getQaKnowledge2());
        result.setQaKnowledge3(qaInterviewResultDetail.getQaKnowledge3());
        result.setQaKnowledge4(qaInterviewResultDetail.getQaKnowledge4());
        result.setQaKnowledge5(qaInterviewResultDetail.getQaKnowledge5());
        result.setQaKnowledge6(qaInterviewResultDetail.getQaKnowledge6());

        return result;
    }

    private static DevInterviewResultDetailDTO convert(DevInterviewResultDetail devInterviewResultDetail)
    {
        DevInterviewResultDetailDTO result = new DevInterviewResultDetailDTO();

        result.setId(devInterviewResultDetail.getId());
        result.setHrOtherInformation(devInterviewResultDetail.getHrOtherInformation());
        result.setHrWorkWithUser(devInterviewResultDetail.getHrWorkWithUser());
        result.setInterviewerOtherInformation(devInterviewResultDetail.getInterviewerOtherInformation());
        result.setInterviewerWorkWithUser(devInterviewResultDetail.getInterviewerWorkWithUser());
        result.setJavaSkill(devInterviewResultDetail.getJavaSkill());
        result.setSqlSkill(devInterviewResultDetail.getSqlSkill());
        result.setDevFinalAssessment(devInterviewResultDetail.getDevFinalAssessment());
        result.setHrFinalAssessment(devInterviewResultDetail.getHrFinalAssessment());

        return result;
    }
}
