package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.mail.Mail;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.filter.MailFilterDTO;

import java.util.List;
import java.util.Map;

public interface MailService {

    void sendRegistrationMessage(String userEmail, String userPassword, String confirmCode) throws ServiceException;
    void sendMessage(List<String> receivers, String messageSubject, String messageBody) throws ServiceException;
    void sendMessage(List<String> receivers, String messageSubject, String messageBody, Map<String, String> vars) throws ServiceException;
    void sendPreparedMessage(List<String> receivers, Mail.PreparedMail preparedMail) throws ServiceException;
    void sendPreparedMessage(List<String> receivers, Mail.PreparedMail preparedMail, Map<String, String> vars) throws ServiceException;
    PagingLoadResultDTO<MailDTO> getMails(PagingLoadConfigDTO loadConfig, MailFilterDTO filter) throws ServiceException;
}