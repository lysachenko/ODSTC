package com.netcracker.tc.server.persistence.model.mail;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by anla1215 on 8/22/2017.
 */
public class MailQueue implements Serializable {
    private Long id;
    private Date addedWhen;
    private Boolean isSent;
    private Boolean isIncorrectMail;
    private String receiverAddress;
    private String messageSubject;
    private String messageBody;

    public Boolean getIsIncorrectMail() {
        return isIncorrectMail;
    }

    public void setIsIncorrectMail(Boolean isIncorrectMail) {
        this.isIncorrectMail = isIncorrectMail;
    }

    public Boolean getIsSent() {
        return isSent;
    }

    public void setIsSent(Boolean sent) {
        isSent = sent;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddedWhen() {
        return addedWhen;
    }


    public void setAddedWhen(Date addedWhen) {
        this.addedWhen = addedWhen;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
