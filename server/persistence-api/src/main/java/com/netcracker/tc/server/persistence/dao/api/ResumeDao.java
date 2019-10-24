package com.netcracker.tc.server.persistence.dao.api;

import com.netcracker.tc.server.persistence.dao.common.IDao;
import com.netcracker.tc.server.persistence.model.resume.Institute;
import com.netcracker.tc.server.persistence.model.resume.KnowledgeType;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.resume.ResumeKnowledge;

import java.util.List;
import java.util.Set;

/**
 * Created by unconsionable on 28.07.2014.
 */
public interface ResumeDao extends IDao<Resume, Long> {

    Institute getInstitute(Long id);

    Resume getDevResume(Long userId);

    List<Institute> getInstitutes();

    KnowledgeType getKnowledgeType(Long id);

    void deleteResumeKnowledges(Set<ResumeKnowledge> resumeKnowledges);

    void save(ResumeKnowledge resumeKnowledge);

    List<KnowledgeType> getKnowledgeTypes();

    List<ResumeKnowledge> getResumeKnowledges(Long devResumeId);
}