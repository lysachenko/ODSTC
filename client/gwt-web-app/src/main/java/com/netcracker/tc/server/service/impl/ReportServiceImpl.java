package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.persistence.dao.impl.ReportDao;
import com.netcracker.tc.server.persistence.model.report.Report;
import com.netcracker.tc.server.service.api.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class ReportServiceImpl implements ReportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    ReportDao reportDao;

    @Override
    public List<Report> getReportList() {
        if(reportDao.getReportList().isEmpty()){
            LOGGER.info("getReportList is empty");
        }
        return reportDao.getReportList();
    }
}
