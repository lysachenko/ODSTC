package com.netcracker.tc.server.persistence.dao.impl;

import com.netcracker.tc.server.persistence.model.report.Report;

import java.util.*;

public class ReportDao {

    public List<Report> getReportList(){
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        List<Report> reportList = new ArrayList<Report>();
        reportList.add(new Report("Ivanov Ivan", date, 1L, 2L, 3L, 4L));
        reportList.add(new Report("Maximov Ivan", date, 1L, 2L, 3L, 4L));
        reportList.add(new Report("Mihailov Ivan", date, 1L, 2L, 3L, 4L));
        reportList.add(new Report("BlaBLa Ivan", date, 1L, 2L, 3L, 4L));

        return reportList;
    }
}
