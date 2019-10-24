package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.persistence.dao.api.InterviewDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.api.XlsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.xls.QAResumeXlsManager;
import com.netcracker.tc.server.util.xls.TotalDevReportXlsManagerImpl;
import com.netcracker.tc.server.util.xls.XlsManagerI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class XlsServiceImpl implements XlsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsServiceImpl.class);

    private static final String XLS_FOLDER = File.separator + "WEB-INF" + File.separator + "xls" + File.separator;
    /*private static final String DEV_INTERVIEW_RESULT_TEMPLATE = "QAResultTemplate.xlsx";*/
    private static final String DEV_INTERVIEW_RESULT_TEMPLATE = "DevResultTemplate.xlsx";
    private static final int PAGE_NUMBER = 0;
    private static final int ITEMS_PER_PAGE = 50;

    @Autowired
    InterviewDao interviewDao;
    @Autowired
    UserDao userDao;

    private String templatePath;

    @Autowired
    public void setServletContext(ServletContext servletContext) {
        this.templatePath = (servletContext.getRealPath("") + XLS_FOLDER + DEV_INTERVIEW_RESULT_TEMPLATE);
    }

    @Override
    public void createInterviewResultXls(Long userId, ServletOutputStream outputStream)
            throws ServiceException {
        try {
            List<InterviewSlot> interviewSlotList = this.interviewDao.getUserInterviewSlots();

            for (InterviewSlot slot : interviewSlotList) {
                // slot.setInterviewResult(this.interviewDao.getInterviewResult(dbkm.getId()));
            }

            LOGGER.info("Loaded interview slots.");

            XlsManagerI managerI = new QAResumeXlsManager();
            managerI.loadTemplate(this.templatePath);
            managerI.writeWorkbook(interviewSlotList);
            managerI.writeToStream(outputStream);

        } catch (IOException e) {
            LOGGER.error("Error on create xlsx document", e);
            throw new ServiceException("Can't create xls document");
        }
    }

    public void createTotalDevReport(ServletOutputStream outputStream) throws ServiceException {
        List<User> users = userDao.getAllStudents();
        List<InterviewSlot> slots = new LinkedList<InterviewSlot>();

        for (User user : users) {
            Set<InterviewSlot> s = user.getInterviewSlots();

            if (!s.isEmpty()) {
                for (InterviewSlot is : s) {
                    InterviewResult ir = interviewDao.getInterviewResult(is.getId());

                    if (ir != null) {
                        is.setInterviewResult(ir);
                        slots.add(is);
                    }
                }
            }
        }

        if (!slots.isEmpty()) {
            try {
                XlsManagerI managerI = new TotalDevReportXlsManagerImpl();
                managerI.initWorkbook();
                managerI.writeWorkbook(slots);
                managerI.writeToStream(outputStream);
            } catch (IOException e) {
                LOGGER.error("Error on create xlsx document", e);

                throw new ServiceException("Can't create xls document");
            }

        } else {
            LOGGER.error("There aren't data for report!");

            throw new ServiceException("There aren't data for report!");
        }
    }
}
