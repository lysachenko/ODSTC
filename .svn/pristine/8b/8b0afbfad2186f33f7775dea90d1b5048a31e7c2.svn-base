package com.netcracker.tc.server.persistence.dao.impl;

import com.google.common.base.Preconditions;
import com.netcracker.tc.server.persistence.dao.api.MailQueueDao;
import com.netcracker.tc.server.persistence.dao.common.AbstractHibernateDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anla1215 on 8/22/2017.
 */
//@Transactional
//@Service
@Repository
public class MailQueueDaoImpl extends AbstractHibernateDao<MailQueue, Long> implements MailQueueDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailQueueDaoImpl.class);
    @Autowired
    public MailQueueDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public MailQueue getNextMail() {
        Criteria criteria = getCurrentSession().createCriteria(MailQueue.class);
        criteria.add(Restrictions.eq("isSent", false));
        criteria.addOrder(Order.desc("addedWhen"));
        List<MailQueue> result = criteria.list();

        if(result.iterator().hasNext()) {
            MailQueue mail = result.iterator().next();
            LOGGER.debug("mycurrent " + mail.getReceiverAddress());

            return mail;
        } else {
            return null;
        }
    }

    public int getProcessedMails() {
        Criteria criteria = getCurrentSession().createCriteria(MailQueue.class);
        criteria.add(Restrictions.eq("IS_SENT", true));

        List result = criteria.list();

        return result.size();
    }

    public int getWaitingMails() {
        Criteria criteria = getCurrentSession().createCriteria(MailQueue.class);
        criteria.add(Restrictions.eq("IS_SENT", false));
        criteria.add(Restrictions.eq("IS_INCORRECT_MAIL", false));
        List result = criteria.list();

        return result.size();
    }

    @Override
    public PagingLoadResult<MailQueue> getMails(PagingLoadConfig loadConfig) {
        Criteria criteria = getCurrentSession().createCriteria(MailQueue.class);
        PagingLoadResult<MailQueue> result = loadPagingData(criteria, loadConfig);


        return result;
    }

    @Override
    public void create(MailQueue entity) {
        Criteria criteria = getCurrentSession().createCriteria(MailQueue.class);
        criteria.add(Restrictions.eq("receiverAddress", entity.getReceiverAddress()));
        criteria.add(Restrictions.eq("messageSubject", entity.getMessageSubject()));
        criteria.add(Restrictions.eq("isSent", false));
        List result = criteria.list();

        if(result.isEmpty()) {
            Preconditions.checkNotNull(entity);
            getCurrentSession().save(entity);
        }
    }
}
