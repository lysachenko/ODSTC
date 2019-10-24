package com.netcracker.tc.server.util.mail;

/**
 * Created by anla1215 on 8/21/2017.
 */
public interface MailManager {
    void addMailInQueue(Mail mail);
    //List<Mail> getFailedMails();
    void processNextMail();

    int processedMails();
    int waitingMails();
    //int failedMails();
}
