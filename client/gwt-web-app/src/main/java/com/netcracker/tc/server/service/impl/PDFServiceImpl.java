package com.netcracker.tc.server.service.impl;

import com.itextpdf.text.DocumentException;
import com.netcracker.tc.server.persistence.dao.impl.ReportDao;
import com.netcracker.tc.server.service.api.*;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.pdf.DetailInfoPDFCreator;
import com.netcracker.tc.server.util.pdf.DevResumePDFCreator;
import com.netcracker.tc.server.util.pdf.QAResumePDFCreator;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class PDFServiceImpl implements PDFService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFServiceImpl.class);

    private static final String PDF_FOLDER = File.separator + "WEB-INF" + File.separator + "pdf" + File.separator;
    private static final String DEV_RESUME_TEMPLATE = "DevResumeTemplate.pdf";
    private static final String QA_RESUME_TEMPLATE = "QAResumeTemplate.pdf";
    private static final String TIMES_FONT = "Times_New_Roman.ttf";

    @Autowired
    ResumeService resumeService;
    @Autowired
    InterviewService interviewService;
    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Autowired
    ReportDao reportDao;

    private DevResumePDFCreator devResumePDFCreator;
    private QAResumePDFCreator qaResumePDFCreator;
    private DetailInfoPDFCreator detailInfoPDFCreator;

    public PDFServiceImpl(){
        devResumePDFCreator = new DevResumePDFCreator();
        qaResumePDFCreator = new QAResumePDFCreator();
        detailInfoPDFCreator = new DetailInfoPDFCreator();
    }

    @Autowired
    public void setServletContext(ServletContext servletContext){
        devResumePDFCreator.setTemplateFilePath(servletContext.getRealPath("") + PDF_FOLDER + DEV_RESUME_TEMPLATE);
        qaResumePDFCreator.setTemplateFilePath(servletContext.getRealPath("") + PDF_FOLDER + QA_RESUME_TEMPLATE);
        try {
            devResumePDFCreator.setTimesFontPath(servletContext.getRealPath("") + PDF_FOLDER + TIMES_FONT);
            qaResumePDFCreator.setTimesFontPath(servletContext.getRealPath("") + PDF_FOLDER + TIMES_FONT);
        } catch (IOException e) {
            LOGGER.error("Can't load font [Times_New_Roman.ttf]", e);
        } catch (DocumentException e) {
            LOGGER.error("Can't load font [Times_New_Roman.ttf]", e);
        }
    }

    @Override
    public void createActiveInterviewDevResumePDF(Long userId, OutputStream outputStream) throws ServiceException{
        if (userId == null){
            LOGGER.error("Can't create pdf. User [{}] not exist.", userId);
            throw new ServiceException("Пользователя с id [" + userId +"] нету в системе");
        }

        UserDTO user = userService.getUser(userId);
        if (user.getStudentDetail() == null){
            LOGGER.error("Can't create pdf. User [{}] don't have StudentDetail information.", userId);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }

        ResumeDTO resume = resumeService.getDevResume(userId);
        InterviewSlotDTO activeUserInterview = interviewService.getActiveUserInterview(userId);

        if (resume == null){
            LOGGER.error("Dev resume null for user [{}]", userId);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }

        if (user.getStudentDetail().getPosition().isDev()){
            createDevPDF(resume, activeUserInterview, outputStream);
        } else {
            createQAPDF(resume, activeUserInterview, outputStream);
        }
    }

    @Override
    public void createActiveDetailInfoPDF(OutputStream outputStream) {
        detailInfoPDFCreator.setList(reportDao.getReportList());
        detailInfoPDFCreator.createPDF(outputStream);
        LOGGER.info("Created pdf for DetailInfoReport");
    }

    private void createQAPDF(ResumeDTO resume, InterviewSlotDTO activeUserInterview, OutputStream outputStream) throws ServiceException {
        if (resume.getQaResumeDetail() == null){
            LOGGER.error("resume [{}] not contain qaResumeDetail information [{}]", resume.getId());
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }

        String photoPath = imageService.getUserPhotoFolderPath() + File.separator + resume.getPhotoPath();

        try {
            qaResumePDFCreator.createPdf(resume, activeUserInterview, photoPath, outputStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        } catch (DocumentException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }
    }

    private void createDevPDF(ResumeDTO resume, InterviewSlotDTO activeUserInterview, OutputStream outputStream) throws ServiceException {
        if (resume.getDevResumeDetail() == null){
            LOGGER.error("resume [{}] not contain devResumeDetail information [{}]", resume.getId());
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }

        String photoPath = imageService.getUserPhotoFolderPath() + File.separator + resume.getPhotoPath();

        try {
            devResumePDFCreator.createPdf(resume, activeUserInterview, photoPath, outputStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        } catch (DocumentException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException("Ошибка создания PDF. Пожалуйста, обратитесь к администратору.");
        }
    }
}