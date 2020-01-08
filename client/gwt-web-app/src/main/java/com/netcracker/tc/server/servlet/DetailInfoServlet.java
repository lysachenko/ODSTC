package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.persistence.dao.impl.ReportDao;
import com.netcracker.tc.server.persistence.model.report.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class DetailInfoServlet extends AutoinjectingRemoteServiceServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailInfoServlet.class);

    @Autowired
    ReportDao reportDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(reportDao==null){
            LOGGER.info("reportDao is null");
        }
            List<Report> reportList = reportDao.getReportList();
            req.setAttribute("reportList", reportList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/report.jsp");
            requestDispatcher.forward(req, resp);
            LOGGER.info("Redirecting to report.jsp");
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
