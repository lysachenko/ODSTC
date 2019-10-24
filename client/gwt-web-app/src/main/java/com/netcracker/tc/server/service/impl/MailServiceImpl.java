package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.converter.ConverterUtil;
import com.netcracker.tc.server.persistence.dao.api.MailQueueDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.mail.MailQueue;
import com.netcracker.tc.server.service.api.MailService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.mail.Mail;
import com.netcracker.tc.server.util.mail.MailManager;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.filter.MailFilterDTO;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MailServiceImpl implements MailService {
    public static final String SUBJECT_FAIL = "[УЦ Неткрекер] Анкета не прошла отбор.";
    public static final String SUBJECT_PASS = "[УЦ Неткрекер] Приглашаем на следующий этап отбора. ";
//    public static final String BODY_PASS = "Pass";
//    public static final String BODY_FAIL = "Fail";
     public static final String BODY_FAIL =
            "Здравствуй!\n" +
                    "\n" +
                    "Благодарим за регистрацию и твой интерес к Учебному центру. Желающих в этом году оказалось очень много, поэтому мы вынуждены проводить конкурс анкет.\n" +
                    "К сожалению, мы не можем предложить тебе участие в этом году.\n" +
                    "Наиболее вероятно, что это произошло по одной из причин: 1) несерьезно заполненная анкета 2) непрофильное высшее образование или отсутствие образования 3) указанный уровень знаний в анкете ниже, чем у других участников.\n" +
                    "\n" +
                    "Будем рады ответить на вопросы, пиши на OdessaTCSupportGroup@NetCracker.com";
    public static final String BODY_PASS =
            "Здравствуйте!\n\n" +
                    "Вашу анкету отобрали к следующему этапу - личному знакомству на HR и техническом интервью. В личном кабинете (http://apply-odessa.edu-netcracker.com:8080/odessa/) перейдите к пункту «Шаг 2», который теперь открыт для вас. Тут нужно выбрать удобное время для встречи из доступных слотов. \n\n" +
                    "Ждем вас в выбранное время с распечатанной анкетой по адресу:  проспект Шевченка, 1, ОНПУ, институт компьютерных систем (корпус № 3), 4-й этаж, ауд. 406, 408, 409. \n\n" +
                    "Будем рады знакомству!\n\n" +
                    "По вопросам рады ответить на OdessaTCSupportGroup@NetCracker.com\n";

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    public MailServiceImpl() {
    }

    //@Autowired
    //private MailManager mailManager;
    @Autowired
    private MailQueueDao mailDao;

    @Override
    public void sendRegistrationMessage(String userEmail, String userPassword, String confirmCode) throws ServiceException {
        LOGGER.debug("sendRegistrationMessage() start.");
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("XXX");
            email.setSmtpPort(00);
            email.setAuthenticator(new DefaultAuthenticator("XXX", "XXX"));
            email.setStartTLSEnabled(true);
            email.setFrom("XXX");
            email.setSubject("Учебный центр Netcracker. Подтверждение регистрации.");
            email.setHtmlMsg("<h2>Рады приветствовать Вас в Учебном центре!</h2>" +
                    "<p>Ваш логин: " + userEmail + "</p><br/>" +
                    //seva0116 fix fix 2 delete password from message
//                    "<p>Ваш пароль: " + userPassword + "</p>" +
                   // "<p>Код подтверждения: " + confirmCode + "</p><br/>" +
                    "<p>С уважением,</p>" +
                    "<p>Учебный центр Netcracker</p>");
            email.addTo(userEmail);
            email.send();
        } catch (EmailException e) {
            LOGGER.error("Can't send Registration message to email", e);
            throw new ServiceException("Ошибка отправки сообщения на email: " + userEmail + " " + e);
        }
    }

    @Override
    public void sendMessage(List<String> receivers, String messageSubject, String messageBody) throws ServiceException {
        sendMessage(receivers, messageBody, messageSubject, Collections.<String, String>emptyMap());
    }

    @Override
    public void sendPreparedMessage(List<String> receivers, Mail.PreparedMail preparedMail) throws ServiceException {
        sendMessage(receivers, preparedMail.getSubject(), preparedMail.getBody(), Collections.<String, String>emptyMap());
    }

    @Override
    public void sendPreparedMessage(List<String> receivers, Mail.PreparedMail preparedMail, Map<String, String> vars) throws ServiceException {
        sendMessage(receivers, preparedMail.getSubject(), preparedMail.getBody(), vars);
    }

    @Override
    public void sendMessage(List<String> receivers, String messageSubject, String messageBody, Map<String, String> vars) throws ServiceException {
        Mail mail = new Mail();
        LOGGER.debug("receivers: {}", receivers);
        LOGGER.debug("messageSubject: {}", messageSubject);
        LOGGER.debug("messageBody: {}", messageBody);
        LOGGER.debug("vars: {}", vars);
        for (String receiverAddress : receivers) {
            mail.addReceiverAddress(receiverAddress);
        }
        mail.setMessageBody(messageBody);
        mail.setVariables(vars);
        mail.setMessageSubject(messageSubject);
        LOGGER.debug("sendMessage");
        //mailManager.addMailInQueue(mail);
    }

    @Override
    public PagingLoadResultDTO<MailDTO> getMails(PagingLoadConfigDTO loadConfig, MailFilterDTO filter) throws ServiceException {
        LOGGER.debug("GetUsers by: {}", loadConfig);
        LOGGER.debug("Filter: {}", filter);

        PagingLoadResult<MailQueue> result = mailDao.getMails(ConverterUtil.convert(loadConfig));

        LOGGER.debug("Loaded: {}", result);

        return new PagingLoadResultDTO<MailDTO>(ConverterUtil.convertMails(result.getItems()), result.getPageNumber(), result.getTotalItemCount());
    }

}