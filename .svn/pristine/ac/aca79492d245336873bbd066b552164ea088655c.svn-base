package com.netcracker.tc.server.util.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import com.netcracker.tc.server.util.DateUtil;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.resume.ResumeKnowledgeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QAResumePDFCreator {

    private static final String LOCATION = "ОНПУ пр. Шевченко, 1, учебный корпус 3 (ИКС), 4 этаж в одной из аудиторий: 406, 408, 409.";

    private static final Logger LOGGER = LoggerFactory.getLogger(QAResumePDFCreator.class);

    private BaseFont timesFont;
    private String templateFilePath;

    public QAResumePDFCreator() {
    }

    public void createPdf(ResumeDTO resume, InterviewSlotDTO interviewSlot, String photoPath, OutputStream outputStream)
            throws IOException, DocumentException {
        PdfReader reader = new PdfReader(templateFilePath);
        PdfStamper stamper = new PdfStamper(reader, outputStream);
        AcroFields acroFields = stamper.getAcroFields();
        acroFields.addSubstitutionFont(timesFont);
        fillFields(new AcroFieldsWrapper(acroFields), resume, interviewSlot);
//        fillPhoto(stamper.getOverContent(1), photoPath);
        stamper.close();
        reader.close();
    }

    private void fillFields(AcroFieldsWrapper fields, ResumeDTO resume, InterviewSlotDTO interviewSlot) throws IOException, DocumentException {
        QAResumeDetailDTO qaResumeDetailDTO = resume.getQaResumeDetail();

        String interviewDate = getFormattedInterviewDate(DateUtil.toServerTimezone(interviewSlot.getInterviewDate()));
        fields.setField("dateInterview1", interviewDate);
        fields.setField("dateInterview2", interviewDate);

        fields.setField("info1", resume.getSurname()); // Фамилия
        fields.setField("info2", resume.getName()); // Имя
        fields.setField("info3", resume.getLastName()); // Отчество
        fields.setField("info4", qaResumeDetailDTO.getInstituteDescription()); // ВУЗ
        fields.setField("info5", qaResumeDetailDTO.getCourse()); // Курс
        fields.setField("info6", qaResumeDetailDTO.getFaculty()); // Факультет
        if (qaResumeDetailDTO.getGraduationYear() != null) {
            fields.setField("info8", String.valueOf(qaResumeDetailDTO.getGraduationYear())); // Год окончания
        }

        fields.setField("location1", LOCATION); // год 1
        fields.setField("location2", LOCATION); // год 2
        fields.setField("id1", resume.getId().toString()); // ID анкеты
        fields.setField("id2", resume.getId().toString()); // ID анкеты

        fields.setField("email", resume.getEmail()); // e-mail
        fields.setField("tel", resume.getTelephoneNum()); // Telephone
        fields.setField("skype", resume.getSkype()); // skype
        fields.setField("otherContacts", qaResumeDetailDTO.getOtherContacts()); // другие контакты

        fields.setField("interestStudy", getBooValue(qaResumeDetailDTO.getTrainingCenterInterest())); // учебный центр/стажировка
        fields.setField("interestWork", getBooValue(qaResumeDetailDTO.getWorkInNetCrackerInterest())); // работа в компании NetCracker
        fields.setField("interestOther", qaResumeDetailDTO.getOtherInterests()); // другое

        fields.setField("qaDevelopment", getBooValue(qaResumeDetailDTO.getQaDevelopment()));
        fields.setField("softwareDevelopment", getBooValue(qaResumeDetailDTO.getSoftwareDevelopment()));
        fields.setField("jobOther", qaResumeDetailDTO.getOtherJobInterests()); // другое

        fields.setField("qaExpertWorkType", getBooValue(qaResumeDetailDTO.getQaExpertWorkType()));
        fields.setField("qaAutomationWorkType", getBooValue(qaResumeDetailDTO.getQaAutomationWorkType()));
        fields.setField("qaDevelopmentWorkType", getBooValue(qaResumeDetailDTO.getQaDevelopmentWorkType()));
        fields.setField("softwareDevelopmentWorkType", getBooValue(qaResumeDetailDTO.getSoftwareDevelopmentWorkType()));
        fields.setField("leadershipWorkType", getBooValue(qaResumeDetailDTO.getLeadershipWorkType()));
        fields.setField("typeWorkOther", qaResumeDetailDTO.getOtherWorkTypeSpecific());


        fields.setField("softwareDevLifeCycle", String.valueOf(qaResumeDetailDTO.getSoftwareDevLifeCycle()));
        fields.setField("qaRoleInLifeCycle", String.valueOf(qaResumeDetailDTO.getQaRoleInLifeCycle()));
        fields.setField("whatIsTestCase", String.valueOf(qaResumeDetailDTO.getWhatIsTestCase()));
        fields.setField("testingType", String.valueOf(qaResumeDetailDTO.getTestingType()));
        fields.setField("whatIsDefect", String.valueOf(qaResumeDetailDTO.getWhatIsDefect()));
        fields.setField("networkTechnologyLevel", String.valueOf(qaResumeDetailDTO.getNetworkTechnology()));
        fields.setField("OOPLevel", String.valueOf(qaResumeDetailDTO.getOOP()));
        fields.setField("dbSqlLevel", String.valueOf(qaResumeDetailDTO.getDbSql()));
        fields.setField("clientServerArchitectureAndWeb", String.valueOf(qaResumeDetailDTO.getClientServerArchitectureAndWeb()));
        fields.setField("technologyOther", qaResumeDetailDTO.getOtherSkillsLevel());

        fields.setField("project", qaResumeDetailDTO.getWorkExperience());
        fields.setField("englishRead", String.valueOf(qaResumeDetailDTO.getEnglishReadLevel()));
        fields.setField("englishWrite", String.valueOf(qaResumeDetailDTO.getEnglishWriteLevel()));
        fields.setField("englishSpeak", String.valueOf(qaResumeDetailDTO.getEnglishSpeakLevel()));

        fields.setField("aboutTrainingCenter", qaResumeDetailDTO.getWhereYouKnowAboutTC());
        fields.setField("promises", qaResumeDetailDTO.getWhyTakeYouInNetCracker());
        fields.setField("additional", qaResumeDetailDTO.getMoreInformationAboutYou());
    }

    private String getBooValue(Boolean trainingCenterInterest) {
        if (trainingCenterInterest){
            return "+";
        }
        return "-";
    }

    private void fillPhoto(PdfContentByte content, String photoPath) throws DocumentException, BadElementException, IOException {
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