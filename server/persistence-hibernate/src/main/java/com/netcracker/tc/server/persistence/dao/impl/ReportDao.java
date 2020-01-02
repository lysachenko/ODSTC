package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.persistence.model.report.Report;
import org.hibernate.*;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

@Transactional
@Service
public class ReportDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportDao.class);

    private SessionFactory sessionFactory;
    private String queryString ="select r.name || ' ' || r.surname as student, i.login,\n" +
            "i.start_time, i.end_time, i.hr_time_for_interview,\n" +
            "i.interview_time_for_interview\n" +
            "from resume r, interview_slot isl, interview i, users u\n" +
            "where r.user_id=u.id \n" +
            "and isl.interview_id = i.id \n" +
            "and isl.user_id =u.id";

    public ReportDao(){}


    public ReportDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        LOGGER.info("created reportdao");
    }


    public List<Report> getReportList(){
        LOGGER.info("intro reportlist");
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(queryString);
        List<Object[]> rows = query.list();
        List<Report> reportList = new ArrayList<Report>();
        for(Object[] row : rows) {
            Report report = new Report();
            report.setStudent(row[0].toString());
            report.setDateInterview((Date) row[1]);
            report.setStartInterview(Long.parseLong(row[2].toString()));
            report.setEndInterview(Long.parseLong(row[3].toString()));
            report.setHrTime(Integer.parseInt(row[4].toString()));
            report.setInterviewTime(Integer.parseInt(row[5].toString()));
            reportList.add(report);
        }
        return reportList;
    }
}
