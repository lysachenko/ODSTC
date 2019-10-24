package com.netcracker.tc.server.util.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import com.netcracker.tc.server.util.DateUtil;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.resume.ResumeKnowledgeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DevResumePDFCreator {

    private static final String LOCATION = "Одесса, проспект Шевченка, 1, ОНПУ, институт компьютерных систем (корпус № 3), 4-й этаж, ауд. 406, 408, 409.";

    private static final Logger LOGGER = LoggerFactory.getLogger(DevResumePDFCreator.class);

    private BaseFont timesFont;
    private String templateFilePath;

    public DevResumePDFCreator() {
    }

    public void createPdf(ResumeDTO resume, InterviewSlotDTO interviewSlot, String photoPath, OutputStream outputStream) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(templateFilePath);
        PdfStamper stamper = new PdfStamper(reader, outputStream);
        AcroFields acroFields = stamper.getAcroFields();
        acroFields.addSubstitutionFont(timesFont);
        fillFields(new AcroFieldsWrapper(acroFields), resume, interviewSlot);
        fillPhoto(stamper.getOverContent(1), photoPath);
        stamper.close();
        reader.close();
    }

    private void fillFields(AcroFieldsWrapper fields, ResumeDTO resume, InterviewSlotDTO interviewSlot) throws IOException, DocumentException {
        DevResumeDetailDTO devResumeDetail = resume.getDevResumeDetail();
        if (interviewSlot != null) {
            String interviewDate = getFormattedInterviewDate(DateUtil.toServerTimezone(interviewSlot.getInterviewDate()));
            fields.setField("dateInterview1", interviewDate);
            fields.setField("dateInterview2", interviewDate);
        }
        fields.setField("surname", resume.getSurname()); // Фамилия
        fields.setField("name", resume.getName()); // Имя
        //TODO added new field to pdf
//        fields.setField("info9", resume.getSurname()); // Фамилия eng
//        fields.setField("info10", resume.getName()); // Имя eng
        fields.setField("last_name", resume.getLastName()); // Отчество
        fields.setField("institute", devResumeDetail.getInstituteDescription()); // ВУЗ
        fields.setField("course", devResumeDetail.getCourse()); // Курс
        fields.setField("faculty", devResumeDetail.getFaculty()); // Факультет
        fields.setField("department", devResumeDetail.getDepartment()); // Кафедра
        fields.setField("specialty", devResumeDetail.getSpecialty());
        if (devResumeDetail.getGraduationYear() != null) {
            fields.setField("graduation_year", String.valueOf(devResumeDetail.getGraduationYear())); // Год окончания
        }

        fields.setField("location1", LOCATION); // год 1
        fields.setField("location2", LOCATION); // год 2
        fields.setField("id1", resume.getId().toString()); // ID анкеты
        fields.setField("id2", resume.getId().toString()); // ID анкеты

        fields.setField("email", resume.getEmail()); // e-mail
        fields.setField("tel", resume.getTelephoneNum()); // Telephone
        fields.setField("skype", resume.getSkype()); // skype
        fields.setField("otherContacts", devResumeDetail.getOtherContacts()); // другие контакты

        fields.setField("interestStudy", devResumeDetail.getTrainingCenterInterest()); // учебный центр/стажировка
        fields.setField("interestWork", devResumeDetail.getWorkInNetCrackerInterest()); // работа в компании NetCracker
        fields.setField("interestOther", devResumeDetail.getOtherJobInterests()); // другое

        fields.setField("typeWorkBackEnd", devResumeDetail.getBackEndInterest());
        fields.setField("typeWorkFrontEnd", devResumeDetail.getFrontEndInterest());
        fields.setField("typeWorkdb", devResumeDetail.getDbInterest());
        fields.setField("typeWorkOther", devResumeDetail.getOtherWorkTypeSpecific());

        List<ResumeKnowledgeDTO> resumeKnowledges = resume.getResumeKnowledges();
        int knowledgeCount = Math.min(5, resumeKnowledges.size());
        for (int i = 0; i < resumeKnowledges.size(); i++) {
            fields.setField("programmingLanguage" + (i + 1), resumeKnowledges.get(i).getKnowledgeType().getDescription());
            fields.setField("programmingLanguageMark" + (i + 1), resumeKnowledges.get(i).getKnowledgeLevel().toString());

        }

        fields.setField("technologyOOP", String.valueOf(devResumeDetail.getOOPLevel()));
        fields.setField("technologyDB", String.valueOf(devResumeDetail.getDbLevel()));
        fields.setField("technologyWeb", String.valueOf(devResumeDetail.getWebLevel()));
        fields.setField("technologyUI", String.valueOf(devResumeDetail.getUserInterfaceLevel()));
        fields.setField("technologyDesign", String.valueOf(devResumeDetail.getUmlLevel()));
        fields.setField("technologyOther", devResumeDetail.getOtherSkillsLevel());

        fields.setField("project", devResumeDetail.getWorkExperience());
        fields.setField("englishRead", String.valueOf(devResumeDetail.getEnglishReadLevel()));
        fields.setField("englishWrite", String.valueOf(devResumeDetail.getEnglishWriteLevel()));
        fields.setField("englishSpeak", String.valueOf(devResumeDetail.getEnglishSpeakLevel()));

        fields.setField("aboutTrainingCenter", devResumeDetail.getWhereYouKnowAboutTC());
        fields.setField("promises", devResumeDetail.getWhyTakeYouInNetCracker());
        fields.setField("additional", devResumeDetail.getMoreInformationAboutYou());
    }

    private void fillPhoto(PdfContentByte content, String photoPath) throws DocumentException, IOException {
        if (!new File(photoPath).isFile())
            return;
        Image image = Image.getInstance(photoPath);
        image.scaleToFit(130, 130);
        image.setAbsolutePosition(60f, 625f);
        content.addImage(image);
    }

    private String getFormattedInterviewDate(Date interviewDate) {
        String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ru"));
        dfs.setMonths(months);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM HH:mm YYYY", dfs);

        return dateFormatter.format(interviewDate);
    }

    public BaseFont getTimesFont() {
        return timesFont;
    }

    public String getTemplateFilePath() {
        return templateFilePath;
    }

    public void setTemplateFilePath(String templateFilePath) {
        this.templateFilePath = templateFilePath;
    }

    public void setTimesFontPath(String timesFontPath) throws IOException, DocumentException {
        timesFont = BaseFont.createFont(timesFontPath, "cp1251", BaseFont.EMBEDDED);
    }
}