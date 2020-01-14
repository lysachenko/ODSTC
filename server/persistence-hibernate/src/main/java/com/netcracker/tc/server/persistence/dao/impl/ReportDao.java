package com.netcracker.tc.server.persistence.dao.impl;

import com.netcracker.tc.server.persistence.model.report.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;


public class ReportDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportDao.class);
    private DataSource dataSource;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    private String queryString = "select r.name || ' ' || r.surname as student, i.login,\n" +
            "i.start_time, i.end_time, i.hr_time_for_interview,\n" +
            "i.interview_time_for_interview\n" +
            "from resume r, interview_slot isl, interview i, users u\n" +
            "where r.user_id=u.id \n" +
            "and isl.interview_id = i.id \n" +
            "and isl.user_id =u.id";


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Report> getReportList() {
        List<Report> reportList = new ArrayList<Report>();
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(queryString);
            rs = ps.executeQuery();


            while (rs.next()) {
                Report report = new Report();
                report.setStudent(rs.getString(1));
                report.setDateInterview(rs.getDate(2));
                report.setStartInterview(rs.getLong(3));
                report.setEndInterview(rs.getLong(4));
                report.setHrTime(rs.getInt(5));
                report.setInterviewTime(rs.getInt(6));
                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reportList;
    }

}


