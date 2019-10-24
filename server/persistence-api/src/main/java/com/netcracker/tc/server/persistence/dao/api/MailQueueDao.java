package com.netcracker.tc.server.persistence.dao.api;

import com.netcracker.tc.server.persistence.dao.common.IDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;

/**
 * Created by anla1215 on 8/22/2017.
 */
public interface MailQueueDao extends IDao<MailQueue, Long> {
    MailQueue getNextMail();
    int getProcessedMails();
    int getWaitingMails();
    PagingLoadResult<MailQueue> getMails(PagingLoadConfig loadConfig);
}
