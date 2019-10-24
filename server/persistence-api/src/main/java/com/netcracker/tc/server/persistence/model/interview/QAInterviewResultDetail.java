package com.netcracker.tc.server.persistence.model.interview;

import java.io.Serializable;

public class QAInterviewResultDetail implements Serializable {

    private Long id;
    private Boolean hrComeToInterview;
    private Boolean hrWorkWithUser;
    private String hrOtherInformation;
    private Integer hrFinalAssessment;

    private Boolean interviewerComeToInterview;
    private Integer qaKnowledge1;  // Жизненный цикл разработки ПО
    private Integer qaKnowledge2;  // Место QA в жизненном цикле разработки ПО
    private Integer qaKnowledge3;  // Что такое (и жизненный цикл) Test Case
    private Integer qaKnowledge4;  // Что такое (и жизненный цикл) Defect
    private Integer qaKnowledge5;  // Типы тестирования (понимание 3х и более)
    private Integer qaKnowledge6;  // Базовое понимание QA Automation (tools,WebDriver)

    private Integer itKnowledge1;  // Сетевые технологии (Localhost, ipconfig, Опыт настройки сети. . IP. DNS. MAC. DHCP. TCP/IP. Почтовые протоколы. Proxy. VPN. SSH. SSL)
    private Integer itKnowledge2;  // Client-Server Architecture and WEB (Client (thick/thin). HTTP, Three-tier architecture, WebServices)
    private Integer itKnowledge3;  // БД и SQL (Понятие СУБД. Ключи. Транзакции. SQL)
    private Integer itKnowledge4;  // Основы программирования и ООП (.Net. Java. OOP. Script-based languages – VBScript, JavaScript. XML)

    private String interviewerBasicInformation;
    private String interviewerOther;
    private Boolean interviewerWorkWithUser;
    private Integer interviewerFinalAssessment;

    private InterviewResult interviewResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InterviewResult getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(InterviewResult interviewResult) {
        this.interviewResult = interviewResult;
    }

    public Boolean getHrComeToInterview() {
        return hrComeToInterview;
    }

    public void setHrComeToInterview(Boolean hrComeToInterview) {
        this.hrComeToInterview = hrComeToInterview;
    }

    public Boolean getHrWorkWithUser() {
        return hrWorkWithUser;
    }

    public void setHrWorkWithUser(Boolean hrWorkWithUser) {
        this.hrWorkWithUser = hrWorkWithUser;
    }

    public String getHrOtherInformation() {
        return hrOtherInformation;
    }

    public void setHrOtherInformation(String hrOtherInformation) {
        this.hrOtherInformation = hrOtherInformation;
    }

    public Integer getHrFinalAssessment() {
        return hrFinalAssessment;
    }

    public void setHrFinalAssessment(Integer hrFinalAssessment) {
        this.hrFinalAssessment = hrFinalAssessment;
    }

    public Boolean getInterviewerComeToInterview() {
        return interviewerComeToInterview;
    }

    public void setInterviewerComeToInterview(Boolean interviewerComeToInterview) {
        this.interviewerComeToInterview = interviewerComeToInterview;
    }

    public Integer getQaKnowledge1() {
        return qaKnowledge1;
    }

    public void setQaKnowledge1(Integer qaKnowledge1) {
        this.qaKnowledge1 = qaKnowledge1;
    }

    public Integer getQaKnowledge2() {
        return qaKnowledge2;
    }

    public void setQaKnowledge2(Integer qaKnowledge2) {
        this.qaKnowledge2 = qaKnowledge2;
    }

    public Integer getQaKnowledge3() {
        return qaKnowledge3;
    }

    public void setQaKnowledge3(Integer qaKnowledge3) {
        this.qaKnowledge3 = qaKnowledge3;
    }

    public Integer getQaKnowledge4() {
        return qaKnowledge4;
    }

    public void setQaKnowledge4(Integer qaKnowledge4) {
        this.qaKnowledge4 = qaKnowledge4;
    }

    public Integer getQaKnowledge5() {
        return qaKnowledge5;
    }

    public void setQaKnowledge5(Integer qaKnowledge5) {
        this.qaKnowledge5 = qaKnowledge5;
    }

    public Integer getQaKnowledge6() {
        return qaKnowledge6;
    }

    public void setQaKnowledge6(Integer qaKnowledge6) {
        this.qaKnowledge6 = qaKnowledge6;
    }

    public Integer getItKnowledge1() {
        return itKnowledge1;
    }

    public void setItKnowledge1(Integer itKnowledge1) {
        this.itKnowledge1 = itKnowledge1;
    }

    public Integer getItKnowledge2() {
        return itKnowledge2;
    }

    public void setItKnowledge2(Integer itKnowledge2) {
        this.itKnowledge2 = itKnowledge2;
    }

    public Integer getItKnowledge3() {
        return itKnowledge3;
    }

    public void setItKnowledge3(Integer itKnowledge3) {
        this.itKnowledge3 = itKnowledge3;
    }

    public Integer getItKnowledge4() {
        return itKnowledge4;
    }

    public void setItKnowledge4(Integer itKnowledge4) {
        this.itKnowledge4 = itKnowledge4;
    }

    public String getInterviewerBasicInformation() {
        return interviewerBasicInformation;
    }

    public void setInterviewerBasicInformation(String interviewerBasicInformation) {
        this.interviewerBasicInformation = interviewerBasicInformation;
    }

    public String getInterviewerOther() {
        return interviewerOther;
    }

    public void setInterviewerOther(String interviewerOther) {
        this.interviewerOther = interviewerOther;
    }

    public Boolean getInterviewerWorkWithUser() {
        return interviewerWorkWithUser;
    }

    public void setInterviewerWorkWithUser(Boolean interviewerWorkWithUser) {
        this.interviewerWorkWithUser = interviewerWorkWithUser;
    }

    public Integer getInterviewerFinalAssessment() {
        return interviewerFinalAssessment;
    }

    public void setInterviewerFinalAssessment(Integer interviewerFinalAssessment) {
        this.interviewerFinalAssessment = interviewerFinalAssessment;
    }
}