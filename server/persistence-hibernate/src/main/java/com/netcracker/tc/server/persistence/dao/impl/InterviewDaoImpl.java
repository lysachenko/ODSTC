package com.netcracker.tc.server.persistence.dao.impl;

import com.netcracker.tc.server.persistence.dao.api.InterviewDao;
import com.netcracker.tc.server.persistence.dao.common.AbstractHibernateDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.interview.Interview;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.user.Position;
import com.netcracker.tc.server.persistence.model.user.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by unconsionable on 29.07.2014.
 */
@Transactional
@Service
@Repository
public class InterviewDaoImpl extends AbstractHibernateDao<Interview, Long> implements InterviewDao{

    @Autowired
    public InterviewDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Interview.class);
    }

    @Override
    public PagingLoadResult<Interview> loadInterviews(PagingLoadConfig loadConfig) {
        Criteria criteria = getCurrentSession().createCriteria(Interview.class);

        int dbItemCount = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

        int pageSize = loadConfig.getPageSize();
        int pageNumber = loadConfig.getPageNumber();

        int dataPageCount = dbItemCount / pageSize;

        pageNumber = pageNumber <= dataPageCount ? pageNumber : dataPageCount;

        int fromRange = pageNumber * pageSize;
        int toRange = Math.min(fromRange + pageSize, dbItemCount);

        criteria.addOrder(Order.desc("interviewDate"));
        criteria.setProjection(null);
        criteria.setFirstResult(fromRange);
        criteria.setMaxResults(toRange - fromRange);

        List<Interview> result = criteria.list();

        return new PagingLoadResult<Interview>(result, fromRange, dbItemCount);
    }

    @Override
    public void createInterviewSlots(InterviewSlot interviewSlot) {
        getCurrentSession().saveOrUpdate(interviewSlot);
    }

    @Override
    public void persist(Interview interview) {
        getCurrentSession().persist(interview);
    }

    @Override
    public List<Interview> getAvailableInterviews(Position position) {
        Query query = getCurrentSession().createQuery("from Interview " +
                "where availablePlaceCount > 0 and position.id = :positionId and enable = true " +
                "and interviewDate > current_date order by interviewDate asc, startTime asc");
        query.setParameter("positionId", position.getId());

        return query.list();
    }

    @Override
    public InterviewSlot getAvailableInterviewSlot(Interview interview, long startTime) {
        Query query = getCurrentSession().createQuery("from InterviewSlot where interview.id = :interviewId and " +
                "time = :time and interview.interviewDate > current_date and interview.enable = true and user is null");
        query.setParameter("interviewId", interview.getId());
        query.setParameter("time", startTime);

        List<InterviewSlot> interviewSlotList = query.list();
        if (interviewSlotList.isEmpty()){
            return null;
        }

        return interviewSlotList.get(0);
    }

    @Override
    public void update(InterviewSlot availableInterviewSlot) {
        getCurrentSession().update(availableInterviewSlot);
    }

    @Override
    public InterviewSlot getActiveUserInterview(User user) {
        Query query = getCurrentSession().createQuery("from InterviewSlot where user.id = :userId ");
        query.setParameter("userId", user.getId());

        List<InterviewSlot> interviewSlotList = query.list();

        for (InterviewSlot interviewSlot: interviewSlotList){
//            if ((interviewSlot.getTime() + interviewSlot.getInterview().getInterviewDate().getTime()) > System.currentTimeMillis()){
                return interviewSlot;
//            }
        }

        return null;
    }

    @Override
    public List<InterviewSlot> getAvailableInterviewSlots(Interview interview) {
        Query query = getCurrentSession().createQuery("select interviewSlot.time " +
                "from InterviewSlot interviewSlot " +
                "where interviewSlot.interview.id = :interviewId and interviewSlot.user is null " +
                "group by interviewSlot.time " +
                "order by interviewSlot.time asc");
        query.setParameter("interviewId", interview.getId());

        List<InterviewSlot> interviewSlotList = new ArrayList<InterviewSlot>();

        for (Iterator it = query.iterate(); it.hasNext();){
            Object time = it.next();

            InterviewSlot slot = new InterviewSlot();
            slot.setTime((Long) time);

            interviewSlotList.add(slot);
        }

        return interviewSlotList;
    }

    @Override
    public List<InterviewSlot> getUserInterviewSlots() {
        Query query = getCurrentSession().createQuery("from InterviewSlot slot where slot.user is not null and slot.interview.position.id = 1");

        return query.list();
    }

    @Override
    public InterviewSlot getLastUserInterview(Long userId) {
        Query query = getCurrentSession().createQuery("from InterviewSlot where user.id = :userId");
        query.setParameter("userId", userId);

        List<InterviewSlot> interviewSlotList = query.list();

        if (interviewSlotList.isEmpty()){
            return null;
        }

        return interviewSlotList.get(0);
    }

    @Override
    public InterviewResult getInterviewResult(Long interviewSlotId) {
        Query query = getCurrentSession().createQuery("from InterviewResult where interviewSlotId = :slotId");
        query.setParameter("slotId", interviewSlotId);

        List<InterviewResult> interviewSlotList = query.list();

        if (interviewSlotList.isEmpty()){
            return null;
        }

        return interviewSlotList.get(0);
    }

    @Override
    public void createOrUpdate(InterviewResult interviewResult) {
        getCurrentSession().saveOrUpdate(interviewResult);
    }

    @Override
    public void create(InterviewResult interviewResult) {
        SQLQuery sqlQuery = getCurrentSession().createSQLQuery("INSERT INTO INTERVIEW_RESULT (INTERVIEW_SLOT_ID) VALUES (?)");
        sqlQuery.setParameter(0, interviewResult.getInterviewSlotId());

        sqlQuery.executeUpdate();
    }

    @Override
    public InterviewSlot getInterviewSlot(Long slotId) {
        return (InterviewSlot) getCurrentSession().get(InterviewSlot.class, slotId);

    }

    @Override
    public void deleteInterview(Long interviewId) {
        // TODO anky0315 Refactoring this code. Delete of a single request(maybe constraint)
        String sqlInterviewSlot = "DELETE FROM INTERVIEW_SLOT WHERE INTERVIEW_ID = ?";
        String sqlInterview = "DELETE FROM INTERVIEW WHERE ID = ?";

        SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sqlInterviewSlot);
        sqlQuery.setParameter(0, interviewId);
        sqlQuery.executeUpdate();

        sqlQuery = getCurrentSession().createSQLQuery(sqlInterview);
        sqlQuery.setParameter(0, interviewId);
        sqlQuery.executeUpdate();

    }
}