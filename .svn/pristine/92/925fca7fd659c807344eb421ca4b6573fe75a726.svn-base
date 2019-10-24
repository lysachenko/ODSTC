package com.netcracker.tc.shared.model.common;

import java.io.Serializable;
import java.util.Date;

public class MailDTO implements Serializable {

    private Date addedDate;
    private Boolean isSent;
    private String receiverAddress;
    private String receiverSubject;
    private String receiverBody;

    public MailDTO(Date addedDate, Boolean isSent, String receiverAddress, String receiverSubject, String receiverBody) {
        this.addedDate = addedDate;
        this.isSent = isSent;
        this.receiverAddress = receiverAddress;
        this.receiverSubject = receiverSubject;
        this.receiverBody = receiverBody;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    public MailDTO(){
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverSubject() {
        return receiverSubject;
    }

    public void setReceiverSubject(String receiverSubject) {
        this.receiverSubject = receiverSubject;
    }

    public String getReceiverBody() {
        return receiverBody;
    }

    public void setReceiverBody(String receiverBody) {
        this.receiverBody = receiverBody;
    }
}