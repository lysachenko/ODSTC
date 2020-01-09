package com.netcracker.tc.server.persistence.model.report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report implements Serializable {

    private String student;
    private String dateInterview;
    private String startInterview;
    private String endInterview;
    private Integer hrTime;
    private Integer interviewTime;

    public Report() {
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getDateInterview() {
        return dateInterview;
    }

    public void setDateInterview(Date dateInterview) {
        this.dateInterview = formatDateToEurDate(dateInterview);
    }

    public String getStartInterview() {
        return startInterview;
    }

    public void setStartInterview(Long startInterview) {
        this.startInterview =formatLongToStrTime(startInterview);

    }

    public String getEndInterview() {
        return endInterview;
    }

    public void setEndInterview(Long endInterview) {
        this.endInterview = formatLongToStrTime(endInterview);
    }

    public Integer getHrTime() {
        return hrTime;
    }

    public void setHrTime(Integer hrTime) {
        this.hrTime = hrTime;
    }

    public Integer getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Integer interviewTime) {
        this.interviewTime = interviewTime;
    }

    private  String formatLongToStrTime(long time) {
        long mod = time % 3600000;
        long hours = 0;
        long mint = 0;

        if (mod != 0)
            mint = mod / 60000;
        else
            mint = 0;

        hours = time / 3600000;

        String hoursStr = String.valueOf(hours);
        String mintsStr = String.valueOf(mint);
        if (hoursStr.length() == 1)
            hoursStr = "0" + hoursStr;

        if (mintsStr.length() == 1)
            mintsStr = "0" + mintsStr;

        return hoursStr + ":" + mintsStr;
    }

    private String formatDateToEurDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate= formatter.format(date);
        return strDate;
    }
}
