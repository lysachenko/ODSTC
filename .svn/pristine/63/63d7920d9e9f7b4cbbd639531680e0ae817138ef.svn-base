package com.netcracker.tc.server.util.mail;

import com.netcracker.tc.server.persistence.model.mail.MailQueue;

import java.util.*;

/**
 * Created by anla1215 on 8/23/2017.
 */
public class Mail {
    private Map<String, String> variables;
    private String messageBody;
    private String messageSubject;
    private List<String> receiverAddresses;

    public Mail() {
        this.variables = new HashMap<String, String>();
        this.receiverAddresses = new ArrayList<String>(5);
        this.messageBody = "";
    }

    public void addVariable(String key, String value) {
        this.variables.put(key, value);
    }

    public void addReceiverAddress(String address) {
        this.receiverAddresses.add(address);
    }

    public void clearAddresses(){
        this.receiverAddresses.clear();
    }

    public String getReceiverAddresses() {
        StringBuilder result = new StringBuilder();
        for(Iterator<String> iterator = this.receiverAddresses.iterator(); iterator.hasNext();){
            result.append(iterator.next());
            if(iterator.hasNext()) {
                result.append(";");
            }
        }
        return result.toString();
    }

    public List<String> getReceiverAddressesList() {
        return this.receiverAddresses;
    }

    public void setVariables(Map<String, String> vars) {
        this.variables = vars;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getRawMessageBody(){
        return this.messageBody;
    }

    public String getMessageBody(){
        String message = this.messageBody;
        for(String variableName: this.variables.keySet()){
            String variableValue = this.variables.get(variableName);
            message = message.replace(variableName, variableValue);
        }
        return message;
    }

    public String getRawMessageSubject(){
        return this.messageSubject;
    }
    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessageSubject(){
        String subject = this.messageSubject;
        for(String variableName: this.variables.keySet()){
            String variableValue = this.variables.get(variableName);
            subject = subject.replace(variableName, variableValue);
        }
        return subject;
    }

    public static Mail fromMailQueue(MailQueue mq) {
        Mail mail = new Mail();
        mail.setMessageSubject(mq.getMessageSubject());
        mail.setMessageBody(mq.getMessageBody());

        String address = mq.getReceiverAddress();
        String[] addresses = address.split(";");
        if(addresses.length > 0) {
            for(int i = 0; i < addresses.length; i++){
                mail.addReceiverAddress(addresses[i]);
            }
        }

        return mail;
    }

    public enum PreparedMail{
        REGISTRATION(REGISTRATION_MESSAGE_SUBJECT, REGISTRATION_MESSAGE_BODY),
        APPROVE(APPROVE_MESSAGE_SUBJECT, APPROVE_MESSAGE_BODY);

        private String body;
        private String subject;
        PreparedMail(String subject, String body) {
            this.subject = subject;
            this.body = body;
        }

        public String getBody(){
            return this.body;
        }

        public String getSubject() {
            return subject;
        }
    }

    private static String REGISTRATION_MESSAGE_SUBJECT = "";
    private static String REGISTRATION_MESSAGE_BODY = "";
    private static String APPROVE_MESSAGE_SUBJECT = "";
    private static String APPROVE_MESSAGE_BODY = "";

}
