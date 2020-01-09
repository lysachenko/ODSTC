package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.persistence.dao.impl.ReportDao;
import com.netcracker.tc.server.persistence.model.report.Report;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ReportService {
    List<Report> getReportList();
}
