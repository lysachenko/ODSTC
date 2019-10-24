package com.netcracker.tc.server.persistence.dao.impl;

import com.netcracker.tc.server.persistence.dao.api.ResumeDao;
import com.netcracker.tc.server.persistence.dao.common.AbstractHibernateDao;
import com.netcracker.tc.server.persistence.model.resume.Institute;
import com.netcracker.tc.server.persistence.model.resume.KnowledgeType;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.resume.ResumeKnowledge;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by unconsionable on 29.07.2014.
 */
//@Transactional
//@Service
@Repository
public class ResumeDaoImpl extends AbstractHibernateDao<Resume, Long> implements ResumeDao {

    @Autowired
    public ResumeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Resume.class);
    }

    @Override
    public Institute getInstitute(Long id) {
        Query query = getCurrentSession().createQuery("from Institute where id = :instituteId");
        query.setParameter("instituteId", id);

        List<Institute> list = query.list();

        if (list.isEmpty()){
            return null;
        }

        return list.get(0);
    }

    @Override
    public Resume getDevResume(Long userId) {
        Query query = getCurrentSession().createQuery("from Resume where user.id = :userId");
        query.setParameter("userId", userId);

        List<Resume> resumeList = query.list();

        if (resumeList.isEmpty()){
            return null;
        }

        return resumeList.get(0);
    }

    @Override
    public List<Institute> getInstitutes() {
        Query query = getCurrentSession().createQuery("from Institute");

        return query.list();
    }

    @Override
    public KnowledgeType getKnowledgeType(Long id) {
        Query query = getCurrentSession().createQuery("from KnowledgeType where id = :id");
        query.setParameter("id", id);

        List<KnowledgeType> resumeList = query.list();

        if (resumeList.isEmpty()){
            return null;
        }

        return resumeList.get(0);
    }

    @Override
    public void deleteResumeKnowledges(Set<ResumeKnowledge> resumeKnowledges) {
        for (ResumeKnowledge resumeKnowledge: resumeKnowledges) {
            getCurrentSession().delete(resumeKnowledge);
        }
    }

    @Override
    public void save(ResumeKnowledge resumeKnowledge) {
        getCurrentSession().save(resumeKnowledge);
    }

    @Override
    public List<KnowledgeType> getKnowledgeTypes() {
        Query query = getCurrentSession().createQuery("from KnowledgeType");

        return query.list();
    }

    @Override
    public List<ResumeKnowledge> getResumeKnowledges(Long devResumeId) {
        Query query = getCurrentSession().createQuery("from ResumeKnowledge rk where rk.resume.id = :resumeId " +
                "order by rk.knowledgeLevel desc, rk.knowledgeType.id asc");
        query.setParameter("resumeId", devResumeId);

        return query.list();
    }
}