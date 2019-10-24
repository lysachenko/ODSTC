package com.netcracker.tc.server.util.mail;

import com.netcracker.tc.server.spring.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by anla1215 on 8/23/2017.
 */
public class MailSender {
    private static Properties props;
//    private static String user;
//    private static String password;

//    private static String USER_PROPERTY = "";
//    private static String PASSWORD_PROPERTY = "";
//    private static String USER_PERSONAL = "";

    private MailSender(){
        props =  new Properties();



//        user = System.getenv(USER_PROPERTY);
//        password = System.getenv(PASSWORD_PROPERTY);
    }


//    public static void sendMail(Mail mail) throws Exception {
//            ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
//            service.setUrl(new URI("https://umail.netcracker.com/EWS/Exchange.asmx"));
//            ExchangeCredentials credentials = new WebCredentials("seva0116", "2679881Qq7",
//                    "netcracker");
//
//            service.setCredentials(credentials);
//
//            EmailMessage msg= null;
//            msg = new EmailMessage(service);
//            msg.setSubject(mail.getMessageSubject());
//            msg.setBody(MessageBody.getMessageBodyFromText(mail.getMessageBody()));
//            msg.getToRecipients().add(mail.getReceiverAddresses());
//            msg.send();
//            service.setTimeout(10000);
//
//    }


//       public static void sendMail(Mail mail, String login, String password) {
//        LOGGER.debug("login test " + login + " pass " + password);
//
//    }
//
//    public static void sendMail(Mail mail, String login, String password) throws MessagingException, javax.mail.MessagingException {
//        try {
//            LOGGER.debug("2 before send mail login " + login + " pass "  + password);
//
//            JavaMailSender sender = getJavaMailSender();
//
//
//            InternetAddress fromAddress = new InternetAddress(login, "some ");
//
//            LOGGER.debug("first ");
//            String msgSubject = mail.getMessageSubject();
//            String msgBody = mail.getMessageBody();
//
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(mail.getReceiverAddresses());
//            message.setSubject(msgSubject);
//            message.setText(msgBody);
//            sender.send(message);
//
//            LOGGER.debug("after send mail");
//
//        } catch (UnsupportedEncodingException e) {
//            throw new MessagingException(e.getMessage(),e);
//        }
//    }

//    @Bean
//    public static JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("umail.netcracker.com");
//        mailSender.setPort(25);
//
//        mailSender.setUsername("survey1_mail@netcracker.com");
//        mailSender.setPassword(MD5.decodeMail());
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.trust", "umail.netcracker.com");
//
//        return mailSender;
//    }

    private static Session getSession(final String user, final String password){
        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);
}
