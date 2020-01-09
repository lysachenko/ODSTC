package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.model.resume.*;
import com.netcracker.tc.shared.model.user.PositionDTO;

import java.util.List;

public interface ResumeService {

    ResumeDTO getDevResume(Long userId) throws ServiceException;

    void editDevResume(Long userId, ResumeDTO resumeDTO) throws ServiceException;

    void submitDevResume(Long userId, ResumeDTO resumeDTO) throws ServiceException;

    void createDevResume(Long userId, ResumeDTO resumeDTO, boolean isValid) throws ServiceException;

    ResumeDTO getQAResume(Long userId) throws ServiceException;

    void editQAResume(Long userId, ResumeDTO qaResumeDTO) throws ServiceException;

    void createQAResume(Long userId, ResumeDTO qaResumeDTO) throws ServiceException;

    void editPosition(Long userId, PositionDTO positionDTO) throws ServiceException;

    List<InstituteDTO> getInstitutes() throws ServiceException;

    void savePhotoPath(Long userId, String fileName) throws ServiceException;

    List<KnowledgeTypeDTO> getKnowledgeTypes() throws ServiceException;
    
    Boolean checkResume(ResumeDTO resumeDTO) throws ServiceException;
}