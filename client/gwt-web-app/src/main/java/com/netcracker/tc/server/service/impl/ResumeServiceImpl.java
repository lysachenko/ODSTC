package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.converter.ConverterUtil;
import com.netcracker.tc.server.persistence.dao.api.ResumeDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.resume.*;
import com.netcracker.tc.server.persistence.model.user.StudentDetail;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.model.resume.*;
import com.netcracker.tc.shared.model.user.PositionDTO;
import com.netcracker.tc.shared.model.user.UserStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Service
public class ResumeServiceImpl implements ResumeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private UserDao userDao;

    public ResumeServiceImpl() {
    }

    @Override
    public ResumeDTO getDevResume(Long userId) throws ServiceException {
        Resume devResume = resumeDao.getDevResume(userId);

        if (devResume != null) {
            devResume.getDevResumeDetail();
        }

        ResumeDTO resumeDTO = ConverterUtil.convert(devResume);
        resumeDTO.setResumeKnowledges(ConverterUtil.convertResumeKnowledges(resumeDao.getResumeKnowledges(devResume.getId())));

        return resumeDTO;
    }

    @Override
    public void editDevResume(Long userId, ResumeDTO resumeDTO) throws ServiceException {
        User user = userDao.get(userId);

        LOGGER.debug("resumeDTO.getPhotoPath() = " + resumeDTO.getPhotoPath());

        Resume resume = user.getResume();
        if (resume == null) {
            resume = new Resume();
        } else {
            resumeDao.deleteResumeKnowledges(resume.getResumeKnowledges());
        }

        resume.setLastName(resumeDTO.getLastName());
        resume.setTelephoneNum(resumeDTO.getTelephoneNum());
        resume.setSkype(resumeDTO.getSkype());
        resume.setEmail(resumeDTO.getEmail());
        resume.setUser(user);
        resume.setName(resumeDTO.getName());
        resume.setEngName(resumeDTO.getEngName());
        resume.setEngSurname(resumeDTO.getEngSurname());
        resume.setPhotoPath(resumeDTO.getPhotoPath());
        resume.setSurname(resumeDTO.getSurname());

        DevResumeDetail devResumeDetail = resume.getDevResumeDetail();
        if (devResumeDetail == null) {
            devResumeDetail = new DevResumeDetail();
        }
        DevResumeDetailDTO devResumeDetailDTO = resumeDTO.getDevResumeDetail();

        devResumeDetail.setInstituteOtherName(devResumeDetailDTO.getInstituteOtherName());
        devResumeDetail.setDepartment(devResumeDetailDTO.getDepartment());
        devResumeDetail.setSpecialty(devResumeDetailDTO.getSpecialty());
        devResumeDetail.setTrainingCenterInterest(devResumeDetailDTO.getTrainingCenterInterest());
        devResumeDetail.setWorkInNetCrackerInterest(devResumeDetailDTO.getWorkInNetCrackerInterest());
        devResumeDetail.setOtherJobInterests(devResumeDetailDTO.getOtherJobInterests());
        devResumeDetail.setBackEndInterest(devResumeDetailDTO.getBackEndInterest());
        devResumeDetail.setFrontEndInterest(devResumeDetailDTO.getFrontEndInterest());
        devResumeDetail.setDbInterest(devResumeDetailDTO.getDbInterest());
        devResumeDetail.setOtherWorkTypeSpecific(devResumeDetailDTO.getOtherWorkTypeSpecific());
        devResumeDetail.setOOPLevel(devResumeDetailDTO.getOOPLevel());
        devResumeDetail.setDbLevel(devResumeDetailDTO.getDbLevel());
        devResumeDetail.setWebLevel(devResumeDetailDTO.getWebLevel());
        devResumeDetail.setUserInterfaceLevel(devResumeDetailDTO.getUserInterfaceLevel());
        devResumeDetail.setUmlLevel(devResumeDetailDTO.getUmlLevel());
        devResumeDetail.setOtherSkillsLevel(devResumeDetailDTO.getOtherSkillsLevel());
        devResumeDetail.setWorkExperience(devResumeDetailDTO.getWorkExperience());
        devResumeDetail.setEnglishReadLevel(devResumeDetailDTO.getEnglishReadLevel());
        devResumeDetail.setEnglishSpeakLevel(devResumeDetailDTO.getEnglishSpeakLevel());
        devResumeDetail.setEnglishWriteLevel(devResumeDetailDTO.getEnglishWriteLevel());
        devResumeDetail.setWhereYouKnowAboutTC(devResumeDetailDTO.getWhereYouKnowAboutTC());
        devResumeDetail.setWhyTakeYouInNetCracker(devResumeDetailDTO.getWhyTakeYouInNetCracker());
        devResumeDetail.setMoreInformationAboutYou(devResumeDetailDTO.getMoreInformationAboutYou());
        devResumeDetail.setCourse(devResumeDetailDTO.getCourse());
        devResumeDetail.setFaculty(devResumeDetailDTO.getFaculty());
        devResumeDetail.setGraduationYear(devResumeDetailDTO.getGraduationYear());
        devResumeDetail.setOtherContacts(devResumeDetailDTO.getOtherContacts());
        devResumeDetail.setInstitute(resumeDao.getInstitute(devResumeDetailDTO.getInstitute().getId()));

        devResumeDetail.setResume(resume);
        resume.setDevResumeDetail(devResumeDetail);

        resumeDao.createOrUpdate(resume);
        saveKnowledges(resume, resumeDTO.getResumeKnowledges());

        StudentDetail studentDetail = user.getStudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.EDITING_CV));
        userDao.update(studentDetail);
    }

    @Override
    public void submitDevResume(Long userId, ResumeDTO resumeDTO) throws ServiceException {
        User user = userDao.get(userId);
        StudentDetail studentDetail = user.getStudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.SUBMISSION_CV));
        userDao.update(studentDetail);
    }

    @Override
    public void createDevResume(Long userId, ResumeDTO resumeDTO, boolean isValid) throws ServiceException {
        editDevResume(userId, resumeDTO);

        User user = userDao.get(userId);

        StudentDetail studentDetail = user.getStudentDetail();
//        if(isValid){
            studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.VERIFICATION_CV));
//        } else {
//            studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.USER_HAS_BAD_RESUME));
//        }

        userDao.update(studentDetail);
    }

    private void saveKnowledges(Resume resume, List<ResumeKnowledgeDTO> resumeKnowledges) {
        for (ResumeKnowledgeDTO knowledgeDTO : resumeKnowledges) {
            ResumeKnowledge resumeKnowledge = new ResumeKnowledge();
            resumeKnowledge.setKnowledgeLevel(knowledgeDTO.getKnowledgeLevel());
            resumeKnowledge.setKnowledgeType(resumeDao.getKnowledgeType(knowledgeDTO.getKnowledgeType().getId()));
            resumeKnowledge.setResume(resume);
            resumeDao.save(resumeKnowledge);
        }
    }

    @Override
    public ResumeDTO getQAResume(Long userId) throws ServiceException {
        Resume devResume = resumeDao.getDevResume(userId);

        if (devResume != null) {
            devResume.getDevResumeDetail();
        }

        ResumeDTO resumeDTO = ConverterUtil.convert(devResume);
        resumeDTO.setResumeKnowledges(ConverterUtil.convertResumeKnowledges(resumeDao.getResumeKnowledges(devResume.getId())));

        return resumeDTO;
    }

    @Override
    public void editQAResume(Long userId, ResumeDTO qaResumeDTO) throws ServiceException {
        User user = userDao.get(userId);

        Resume resume = user.getResume();
        if (resume == null) {
            resume = new Resume();
        }

        resume.setLastName(qaResumeDTO.getLastName());
        resume.setTelephoneNum(qaResumeDTO.getTelephoneNum());
        resume.setSkype(qaResumeDTO.getSkype());
        resume.setEmail(qaResumeDTO.getEmail());
        resume.setUser(user);
        resume.setName(qaResumeDTO.getName());
        resume.setPhotoPath(qaResumeDTO.getPhotoPath());
        resume.setSurname(qaResumeDTO.getSurname());

        QAResumeDetail qaResumeDetail = resume.getQaResumeDetail();
        if (qaResumeDetail == null) {
            qaResumeDetail = new QAResumeDetail();
        }
        QAResumeDetailDTO qaResumeDetailDTO = qaResumeDTO.getQaResumeDetail();

        qaResumeDetail.setInstitute(resumeDao.getInstitute(qaResumeDetailDTO.getInstitute().getId()));
        qaResumeDetail.setInstituteOtherName(qaResumeDetailDTO.getInstituteOtherName());
        qaResumeDetail.setCourse(qaResumeDetailDTO.getCourse());
        qaResumeDetail.setFaculty(qaResumeDetailDTO.getFaculty());
        qaResumeDetail.setGraduationYear(qaResumeDetailDTO.getGraduationYear());
        qaResumeDetail.setIsStudent(qaResumeDetailDTO.getIsStudent());
        qaResumeDetail.setOtherContacts(qaResumeDetailDTO.getOtherContacts());
        qaResumeDetail.setTrainingCenterInterest(qaResumeDetailDTO.getTrainingCenterInterest());
        qaResumeDetail.setWorkInNetCrackerInterest(qaResumeDetailDTO.getWorkInNetCrackerInterest());
        qaResumeDetail.setOtherInterests(qaResumeDetailDTO.getOtherInterests());
        qaResumeDetail.setQaDevelopment(qaResumeDetailDTO.getQaDevelopment());
        qaResumeDetail.setSoftwareDevelopment(qaResumeDetailDTO.getSoftwareDevelopment());
        qaResumeDetail.setOtherJobInterests(qaResumeDetailDTO.getOtherJobInterests());
        qaResumeDetail.setQaExpertWorkType(qaResumeDetailDTO.getQaExpertWorkType());
        qaResumeDetail.setQaAutomationWorkType(qaResumeDetailDTO.getQaAutomationWorkType());
        qaResumeDetail.setQaDevelopmentWorkType(qaResumeDetailDTO.getQaDevelopmentWorkType());
        qaResumeDetail.setSoftwareDevelopmentWorkType(qaResumeDetailDTO.getSoftwareDevelopmentWorkType());
        qaResumeDetail.setLeadershipWorkType(qaResumeDetailDTO.getLeadershipWorkType());
        qaResumeDetail.setOtherWorkTypeSpecific(qaResumeDetailDTO.getOtherWorkTypeSpecific());

        qaResumeDetail.setSoftwareDevLifeCycle(qaResumeDetailDTO.getSoftwareDevLifeCycle());
        qaResumeDetail.setQaRoleInLifeCycle(qaResumeDetailDTO.getQaRoleInLifeCycle());
        qaResumeDetail.setWhatIsTestCase(qaResumeDetailDTO.getWhatIsTestCase());
        qaResumeDetail.setWhatIsDefect(qaResumeDetailDTO.getWhatIsDefect());
        qaResumeDetail.setTestingType(qaResumeDetailDTO.getTestingType());
        qaResumeDetail.setNetworkTechnology(qaResumeDetailDTO.getNetworkTechnology());
        qaResumeDetail.setOOP(qaResumeDetailDTO.getOOP());
        qaResumeDetail.setDbSql(qaResumeDetailDTO.getDbSql());
        qaResumeDetail.setClientServerArchitectureAndWeb(qaResumeDetailDTO.getClientServerArchitectureAndWeb());

        qaResumeDetail.setOtherSkillsLevel(qaResumeDetailDTO.getOtherSkillsLevel());
        qaResumeDetail.setWorkExperience(qaResumeDetailDTO.getWorkExperience());
        qaResumeDetail.setEnglishReadLevel(qaResumeDetailDTO.getEnglishReadLevel());
        qaResumeDetail.setEnglishSpeakLevel(qaResumeDetailDTO.getEnglishSpeakLevel());
        qaResumeDetail.setEnglishWriteLevel(qaResumeDetailDTO.getEnglishWriteLevel());
        qaResumeDetail.setWhereYouKnowAboutTC(qaResumeDetailDTO.getWhereYouKnowAboutTC());
        qaResumeDetail.setWhyTakeYouInNetCracker(qaResumeDetailDTO.getWhyTakeYouInNetCracker());
        qaResumeDetail.setMoreInformationAboutYou(qaResumeDetailDTO.getMoreInformationAboutYou());

        qaResumeDetail.setResume(resume);
        resume.setQaResumeDetail(qaResumeDetail);

        resumeDao.createOrUpdate(resume);
    }

    @Override
    public void createQAResume(Long userId, ResumeDTO qaResumeDTO) throws ServiceException {
        editQAResume(userId, qaResumeDTO);

        User user = userDao.get(userId);

        StudentDetail studentDetail = user.getStudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.REGISTRATION_ON_INTERVIEW));

        userDao.update(studentDetail);
    }

    @Override
    public void editPosition(Long userId, PositionDTO positionDTO) throws ServiceException {
        User user = userDao.get(userId);

        if (user == null) {
            throw new ServiceException("Пользователя с id [" + userId + "] нету в системе");
        }

        StudentDetail studentDetail = user.getStudentDetail();

        studentDetail.setPosition(userDao.getPosition(positionDTO.getId()));
        studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.FILLING_CV));

        userDao.update(studentDetail);
    }

    @Override
    public List<InstituteDTO> getInstitutes() throws ServiceException {
        List<Institute> institutes = resumeDao.getInstitutes();

        return ConverterUtil.convertInstitutes(institutes);
    }

    @Override
    public void savePhotoPath(Long userId, String fileName) throws ServiceException {
        User user = userDao.get(userId);

        Resume resume = user.getResume();
        if (resume == null) {
            resume = new Resume();
        }

        resume.setPhotoPath(fileName);
        resume.setUser(user);
        resumeDao.createOrUpdate(resume);
    }

    @Override
    public List<KnowledgeTypeDTO> getKnowledgeTypes() throws ServiceException {
        List<KnowledgeType> knowledgeTypes = resumeDao.getKnowledgeTypes();

        return ConverterUtil.convertKnowledgeTypes(knowledgeTypes);
    }

    @Override
    public Boolean checkResume(ResumeDTO resumeDTO) throws ServiceException {
        //TODO should realize logic for checking resume using SettingsService
        DevResumeDetailDTO resume = resumeDTO.getDevResumeDetail();

//        int year = resume.getGraduationYear();
        int course;
//        String learning = resume.getTrainingCenterInterest();
//        String working = resume.getWorkInNetCrackerInterest();

        if (resume.getCourse().length()>1)
            course = 6;  //graduated
        else
            course = Integer.valueOf(resume.getCourse()) ;

        if (course < 4)  {
            return false;
        }
//        if (learning.equals("-")
//                || learning.equals("?")
//                || working.equals("-")
//                || working.equals("?")) {
//            return false;
//        }

        return true;
    }
}
