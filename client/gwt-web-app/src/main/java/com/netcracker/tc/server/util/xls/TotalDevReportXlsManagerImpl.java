package com.netcracker.tc.server.util.xls;

import com.netcracker.tc.server.persistence.model.interview.DevInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.resume.DevResumeDetail;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.impl.ImageServiceImpl;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.slf4j.LoggerFactory;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.slf4j.Logger;

public class TotalDevReportXlsManagerImpl implements XlsManagerI {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractXlsManager.class);

    private static final String TEXT_SHEET_NAME = "Report";
    private static final String TEXT_NUMBER = "№";
    private static final String TEXT_PHOTO = "Фото";
    private static final String TEXT_PERSONAL_INFO = "Персональная информация";
    private static final String TEXT_FIO = "ФИО";
    private static final String TEXT_HIGH_SCHOOL = "ВУЗ";
    private static final String TEXT_COURSE = "Курс";
    private static final String TEXT_FACULTY = "Факультет";
    private static final String TEXT_CHAIR = "Кафедра";
    private static final String TEXT_SPECIALITY = "Специальность";
    private static final String TEXT_END_YEAR = "Год окончания";
    private static final String TEXT_CONTACTS = "Контакты";
    private static final String TEXT_EMAIL = "E-mail";
    private static final String TEXT_TELEPHONE = "Телефон";
    private static final String TEXT_SKYPE = "Skype";
    private static final String TEXT_OTHER_CONTACTS = "Другие контакты";
    private static final String TEXT_TECHNICAL_COMMENTS = "Техническое комментарии";
    private static final String TEXT_HR_INTERVIEWER = "HR-интервьювер";
    private static final String TEXT_TECH_INTERVIEWER = "Технический интервьювер";
    private static final String TEXT_IS_READY_FOR_HIRING = "Брать в УЦ?";
    private static final String TEXT_ENROLLMENT = "Зачисление (точно да / скорее да / скорее нет / точно нет)";
    private static final String TEXT_KNOWLEDGE_OF_JAVA = "Знания Java";
    private static final String TEXT_KNOWLEDGE_OF_SQL = "Знания SQL";
    private static final String TEXT_TEAM_WORKING = "Готов ли я работать в команде с ним (да / нет)";
    private static final String TEXT_GENERAL_INFO = "Общая информация, личные впечатления";
    private static final String TEXT_HR_COMMENTS = "HR интервью";
    private static final String TEXT_INTERVIEW_DATE = "Дата собеседования";
    private static final String TEXT_IS_WAS_ON_INTERVIEW = "Пришел на собеседование";
    private static final String TEXT_IMPRESSION = "Впечатление";
    private static final String TEXT_TRAINEESHIP = "Что заинтересовало (+, ±, –, ?) Учебный центр/стажировка";
    private static final String TEXT_WORK = "Что заинтересовало (+, ±, –, ?) Работа в компании NetCracker";
    private static final String TEXT_TYPE_OF_WORK = "Тип работы";
    private static final String TEXT_TECHNICAL_INFORMATION = "Техническая информация";
    private static final String TEXT_MARK_OF_KNOWLADGE = "Как ты оцениваешь свои знания по разделам (по шкале от 0 до 5)";
    private static final String TEXT_ADDITIONAL_SKILL_LEVEL = "Дополнительный уровень навыков";
    private static final String TEXT_EXPIERENCE = "Если у вас уже есть опыт работы и/или выполненные учебные проекты, опиши их";
    private static final String TEXT_WHY_NEED = "Почему вас обязательно надо взять в NetCracker";
    private static final String TEXT_ADITTIONAL_INFO = "Дополнительные сведения о себе";
    private static final String TEXT_INTERESTS = "Интересы";

    protected static final String BIG_BOLD_FONT_STYLE = "bigFontCenteredAndBold";
    protected static final String BLUE_BIG_BOLD_FONT_STYLE = "blueBigFontCenteredAndBold";
    protected static final String NORMAL_BOLD_FONT_STYLE = "normalFontCenteredAndBold";
    protected static final String DEFAULT_STYLE = "defaultCentered";

    protected Workbook workbook = null;
    protected Map<String, CellStyle> styles;
    private List<PreparedData> data;

    protected Workbook getDevTemplateWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        this.styles = createStyles(workbook);

        Sheet sheet = workbook.createSheet(TEXT_SHEET_NAME);

        sheet.setDefaultColumnStyle(0, styles.get(DEFAULT_STYLE));
        sheet.setDefaultColumnWidth(20);
        sheet.setDefaultRowHeight((short) 1000);
        sheet.setColumnWidth(0, 1500);

        Row firstHeaderRow = sheet.createRow(0);
        firstHeaderRow.setRowStyle(styles.get(NORMAL_BOLD_FONT_STYLE));
        firstHeaderRow.setHeightInPoints(50);
        Row secondHeaderRow = sheet.createRow(1);
        secondHeaderRow.setRowStyle(styles.get(NORMAL_BOLD_FONT_STYLE));
        secondHeaderRow.setHeightInPoints(15);

        Cell a1a2 = firstHeaderRow.createCell(0);
        a1a2.setCellValue(TEXT_NUMBER);
        a1a2.setCellStyle(styles.get(BLUE_BIG_BOLD_FONT_STYLE));

        Cell b1b2 = firstHeaderRow.createCell(1);
        b1b2.setCellValue(TEXT_PHOTO);
        b1b2.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));

        Cell c1i1 = firstHeaderRow.createCell(2);
        c1i1.setCellValue(TEXT_PERSONAL_INFO);
        c1i1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));

        Cell c2 = secondHeaderRow.createCell(2);
        c2.setCellValue(TEXT_FIO);
        Cell d2 = secondHeaderRow.createCell(3);
        d2.setCellValue(TEXT_HIGH_SCHOOL);
        Cell e2 = secondHeaderRow.createCell(4);
        e2.setCellValue(TEXT_COURSE);
        Cell f2 = secondHeaderRow.createCell(5);
        f2.setCellValue(TEXT_FACULTY);
        Cell g2 = secondHeaderRow.createCell(6);
        g2.setCellValue(TEXT_CHAIR);
        Cell h2 = secondHeaderRow.createCell(7);
        h2.setCellValue(TEXT_SPECIALITY);
        Cell i2 = secondHeaderRow.createCell(8);
        i2.setCellValue(TEXT_END_YEAR);

        Cell j1l1 = firstHeaderRow.createCell(9);
        j1l1.setCellValue(TEXT_CONTACTS);
        j1l1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));

        Cell j2 = secondHeaderRow.createCell(9);
        j2.setCellValue(TEXT_EMAIL);
        Cell k2 = secondHeaderRow.createCell(10);
        k2.setCellValue(TEXT_TELEPHONE);
        Cell l2 = secondHeaderRow.createCell(11);
        l2.setCellValue(TEXT_SKYPE);
        Cell m2 = secondHeaderRow.createCell(12);
        m2.setCellValue(TEXT_OTHER_CONTACTS);

        Cell n1n2 = firstHeaderRow.createCell(13);
        n1n2.setCellValue(TEXT_INTERVIEW_DATE);

        Cell o1o2 = firstHeaderRow.createCell(14);
        o1o2.setCellValue(TEXT_IS_WAS_ON_INTERVIEW);

        Cell p1s1 = firstHeaderRow.createCell(15);
        p1s1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));
        p1s1.setCellValue(TEXT_HR_COMMENTS);

        Cell p2 = secondHeaderRow.createCell(15);
        p2.setCellValue(TEXT_HR_INTERVIEWER);
        Cell q2 = secondHeaderRow.createCell(16);
        q2.setCellValue(TEXT_TEAM_WORKING);
        Cell r2 = secondHeaderRow.createCell(17);
        r2.setCellValue(TEXT_IS_READY_FOR_HIRING);
        Cell s2 = secondHeaderRow.createCell(18);
        s2.setCellValue(TEXT_IMPRESSION);

        Cell t1y1 = firstHeaderRow.createCell(19);
        t1y1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));
        t1y1.setCellValue(TEXT_TECHNICAL_COMMENTS);

        Cell t2 = secondHeaderRow.createCell(19);
        t2.setCellValue(TEXT_TECH_INTERVIEWER);
        Cell u2 = secondHeaderRow.createCell(20);
        u2.setCellValue(TEXT_TEAM_WORKING);
        Cell v2 = secondHeaderRow.createCell(21);
        v2.setCellValue(TEXT_IS_READY_FOR_HIRING);
        Cell w2 = secondHeaderRow.createCell(22);
        w2.setCellValue(TEXT_KNOWLEDGE_OF_JAVA);
        Cell x2 = secondHeaderRow.createCell(23);
        x2.setCellValue(TEXT_KNOWLEDGE_OF_SQL);
        Cell y2 = secondHeaderRow.createCell(24);
        y2.setCellValue(TEXT_IMPRESSION);

        Cell z1ab1 = firstHeaderRow.createCell(25);
        z1ab1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));
        z1ab1.setCellValue(TEXT_TECHNICAL_COMMENTS);

        Cell z2 = secondHeaderRow.createCell(25);
        z2.setCellValue(TEXT_TRAINEESHIP);
        Cell aa2 = secondHeaderRow.createCell(26);
        aa2.setCellValue(TEXT_WORK);
        Cell ab2 = secondHeaderRow.createCell(27);
        ab2.setCellValue(TEXT_TYPE_OF_WORK);

        Cell ac1ag1 = firstHeaderRow.createCell(28);
        ac1ag1.setCellStyle(styles.get(BIG_BOLD_FONT_STYLE));
        ac1ag1.setCellValue(TEXT_TECHNICAL_INFORMATION);

        Cell ac2 = secondHeaderRow.createCell(28);
        ac2.setCellValue(TEXT_MARK_OF_KNOWLADGE);
        Cell ad2 = secondHeaderRow.createCell(29);
        ad2.setCellValue(TEXT_ADDITIONAL_SKILL_LEVEL);
        Cell ae2 = secondHeaderRow.createCell(30);
        ae2.setCellValue(TEXT_EXPIERENCE);
        Cell af2 = secondHeaderRow.createCell(32);
        af2.setCellValue(TEXT_WHY_NEED);
        Cell ag2 = secondHeaderRow.createCell(32);
        ag2.setCellValue(TEXT_ADITTIONAL_INFO);

        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$A$2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$B$1:$B$2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$C$1:$I$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$J$1:$M$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$N$1:$N$2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$O$1:$O$2"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$P$1:$S$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$T$1:$Y$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$1:$AB$1"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$AC$1:$AG$1"));

        return workbook;
    }

    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

        CellStyle style;

        Font bigBoldFont = wb.createFont();
        bigBoldFont.setFontHeightInPoints((short) 20);
        bigBoldFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setFont(bigBoldFont);
        styles.put(BIG_BOLD_FONT_STYLE, style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setFont(bigBoldFont);
        //style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        //style.setFillPattern(SOLID_FOREGROUND);
        styles.put(BLUE_BIG_BOLD_FONT_STYLE, style);

        Font normalBoldFont = wb.createFont();
        normalBoldFont.setFontHeightInPoints((short) 16);
        normalBoldFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(normalBoldFont);
        style.setWrapText(true);
        styles.put(NORMAL_BOLD_FONT_STYLE, style);

        Font normalFont = wb.createFont();
        normalFont.setFontHeightInPoints((short) 12);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(normalFont);
        style.setWrapText(true);
        styles.put(DEFAULT_STYLE, style);

        return styles;
    }

    @Override
    public void initWorkbook() {
        
        this.workbook = getDevTemplateWorkbook();
        
    }

    @Override
    public void loadTemplate(String paramString) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void writeWorkbook(List slots) {
        List<PreparedData> data = new LinkedList<PreparedData>();
        for (Object obj : slots) {
            InterviewSlot is = (InterviewSlot) obj;
                data.add(getPreparedData(is));       
        }
        
        for(int i = 0 ; i < data.size(); i++){
            addRow(workbook, data.get(i), i);
        }
        
    }

    @Override
    public void writeToFile(String filePath)
            throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filePath);

        this.workbook.write(fileOut);
        fileOut.close();
    }

    @Override
    public void writeToStream(OutputStream stream)
            throws IOException {
        this.workbook.write(stream);
        stream.close();
    }

    private PreparedData getPreparedData(InterviewSlot interviewSlot) {
        PreparedData data = new PreparedData();
        User user = interviewSlot.getUser();
        Resume resume = user.getResume();
        DevResumeDetail devResumeDetail = resume.getDevResumeDetail();
        
        InterviewResult interviewResult = interviewSlot.getInterviewResult();

        data.photo = data.getPhotoInstance(ImageServiceImpl.userPhotoFolderPath + File.separator + resume.getPhotoPath());

        data.fio = resume.getSurname() + " " + resume.getName() + " " + resume.getLastName();
        if (devResumeDetail != null) {
            if (devResumeDetail.getInstitute() != null) {
                if (devResumeDetail.getInstitute().getId().equals(InstituteDTO.OTHER_INSTITUTE_ID)) {
                        data.highSchool = getValue(devResumeDetail.getInstituteOtherName());
                    
                } else {
                    data.highSchool = devResumeDetail.getInstitute().getDescription();
                }
            }
            data.course = String.valueOf(devResumeDetail.getCourse());
            data.faculty = String.valueOf(devResumeDetail.getFaculty());
            data.chair = String.valueOf(devResumeDetail.getDepartment());
            data.speciality = String.valueOf(devResumeDetail.getSpecialty());

            if (devResumeDetail.getGraduationYear() != null) {
                data.endYear = String.valueOf(devResumeDetail.getGraduationYear());
            }
            if (devResumeDetail.getOtherContacts() != null) {
                data.otherContacts = String.valueOf(devResumeDetail.getOtherContacts());
            }
        }
        data.email = String.valueOf(resume.getEmail());

        if (resume.getTelephoneNum() != null) {
            data.phoneNumber = getValue(resume.getTelephoneNum());
        }
        if (resume.getSkype() != null) {
            data.skype = getValue(resume.getSkype());
        }

        DevInterviewResultDetail devInterviewResultDetail = interviewResult.getDevInterviewResultDetail();

        Date date = new Date(interviewSlot.getInterview().getInterviewDate().getTime() + interviewSlot.getTime());
        SimpleDateFormat dt = new SimpleDateFormat("dd-mm hh:mm");       
        
        data.interviewDate = dt.format(date);
        data.wasOnInterview = getValue(getYesNo(interviewResult.getIsCome()));

        data.hrInterviewer = getValue((interviewResult.getHr() != null)? interviewResult.getHr().getLogin(): null);
        data.isHrWantTake = getValue(getFinalAssessment(devInterviewResultDetail.getHrFinalAssessment()));
        data.isHrWantWorkWith = getYesNo(devInterviewResultDetail.getHrWorkWithUser());
        data.hrImpression = getValue(devInterviewResultDetail.getHrOtherInformation());

        data.techInterviewer = getValue((interviewResult.getInterviewer() != null)? interviewResult.getInterviewer().getLogin(): null);
        data.isTechWantWorkWith = getValue(getYesNo(interviewResult.getDevInterviewResultDetail().getInterviewerWorkWithUser()));
        data.isTechWantTake = getValue(getFinalAssessment(interviewResult.getDevInterviewResultDetail().getDevFinalAssessment()));

        if (devInterviewResultDetail.getJavaSkill() != null) {
            data.javaKnowledge =  getValue(devInterviewResultDetail.getJavaSkill());
        }
        if (devInterviewResultDetail.getSqlSkill() != null) {
            data.sqlKnowledge = getValue(devInterviewResultDetail.getSqlSkill());
        }
        data.techImpression =getValue( interviewResult.getDevInterviewResultDetail().getInterviewerOtherInformation());

        data.traineeship = getValue(devResumeDetail.getTrainingCenterInterest());
        
        data.jobInNC = getValue(devResumeDetail.getWorkInNetCrackerInterest());
        if(devResumeDetail.getOtherJobInterests() != null && !devResumeDetail.getOtherJobInterests().isEmpty()){
            data.jobInNC += " ; Other = " + devResumeDetail.getOtherJobInterests();
        }

        data.typeOfWork = "Backend = " + getValue(devResumeDetail.getBackEndInterest()) 
                    + "; Frontend = " + getValue(devResumeDetail.getFrontEndInterest() )
                    + "; DB = " + getValue(devResumeDetail.getDbInterest());
        
        if(devResumeDetail.getOtherWorkTypeSpecific() != null && !devResumeDetail.getOtherWorkTypeSpecific().isEmpty()){
            data.typeOfWork += "; Other = " + getValue(devResumeDetail.getOtherWorkTypeSpecific());
        }
                    

        data.ownEstimation = "OOP = " + getValue(devResumeDetail.getOOPLevel()) 
                + "; DB = " + getValue(devResumeDetail.getDbLevel() )
                + "; UI = " + getValue(devResumeDetail.getUserInterfaceLevel()) 
                + "; UML = " + getValue(devResumeDetail.getUmlLevel() );
        data.additionalSkills = getValue(devResumeDetail.getOtherSkillsLevel());
        data.expierence = getValue(devResumeDetail.getWorkExperience());
        data.reasons = getValue(devResumeDetail.getWhyTakeYouInNetCracker());
        data.additionalInfo = getValue(devResumeDetail.getMoreInformationAboutYou());
        
        
        return data;
    }
    
    protected void addRow(Workbook wb, PreparedData data, int rowNum){
        Row newRow = wb.getSheetAt(0).createRow(rowNum + 2);
        newRow.setRowStyle(styles.get(DEFAULT_STYLE));
        newRow.createCell(0).setCellValue("" + (rowNum + 1));
        
        if(data.photo != null){            
            img(wb, data.photo, rowNum + 2, 1);
        } else {
            LOGGER.debug("PHOTO IS NULL!!!");
        }
        
        newRow.createCell(2).setCellValue(data.fio);
        newRow.createCell(3).setCellValue(data.highSchool);
        newRow.createCell(4).setCellValue(data.course);
        newRow.createCell(5).setCellValue(data.faculty);
        newRow.createCell(6).setCellValue(data.chair);
        newRow.createCell(7).setCellValue(data.speciality);
        newRow.createCell(8).setCellValue(data.endYear);
        
        newRow.createCell(9).setCellValue(data.email);
        newRow.createCell(10).setCellValue(data.phoneNumber);
        newRow.createCell(11).setCellValue(data.skype);
        newRow.createCell(12).setCellValue(data.otherContacts);
        
        newRow.createCell(13).setCellValue(data.interviewDate);
        newRow.createCell(14).setCellValue(data.wasOnInterview);
        
        newRow.createCell(15).setCellValue(data.hrInterviewer);
        newRow.createCell(16).setCellValue(data.isHrWantWorkWith);
        newRow.createCell(17).setCellValue(data.isHrWantTake);
        newRow.createCell(18).setCellValue(data.hrImpression);
        
        newRow.createCell(19).setCellValue(data.techInterviewer);
        newRow.createCell(20).setCellValue(data.isTechWantWorkWith);
        newRow.createCell(21).setCellValue(data.isTechWantTake);
        newRow.createCell(22).setCellValue(data.javaKnowledge);
        newRow.createCell(23).setCellValue(data.sqlKnowledge);
        newRow.createCell(24).setCellValue(data.techImpression);
        
        newRow.createCell(25).setCellValue(data.traineeship);
        newRow.createCell(26).setCellValue(data.jobInNC);
        newRow.createCell(27).setCellValue(data.typeOfWork);
        
        newRow.createCell(28).setCellValue(data.ownEstimation);
        newRow.createCell(29).setCellValue(data.additionalSkills);
        newRow.createCell(30).setCellValue(data.expierence);
        newRow.createCell(31).setCellValue(data.reasons);
        newRow.createCell(32).setCellValue(data.additionalInfo);
  
    }
    
     protected void img(Workbook wb, Photo photo, int rowNum, int cellNum){
        InputStream inputStream = null;
        byte[] bytes = photo.img;

        int pictureIdx;

        if(photo.type.equals("jpg") || photo.type.equals("jpeg")){
            pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        } else if (photo.type.equals("png")){
            pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        } else {
            LOGGER.error("ELSE!");
            return;
        }

        Sheet sheet = wb.getSheetAt(0);
        CreationHelper helper = wb.getCreationHelper();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(cellNum); 
        anchor.setRow1(rowNum); 
        anchor.setCol2(cellNum + 1); 
        anchor.setRow2(rowNum + 1); 

        Picture pict = drawing.createPicture(anchor, pictureIdx);

        Cell cell = sheet.getRow(rowNum).createCell(cellNum);

        //set width to n character widths = count characters * 256
        int widthUnits = 20*256;
        sheet.setColumnWidth(1, widthUnits);

        //set height to n points in twips = n * 20
        short heightUnits = 60*30;
        cell.getRow().setHeight(heightUnits);
    }
    
    protected String getYesNo(Boolean var){
        if(var == null) return "";
        return var ? "Да" : "Нет";
    }
    
    protected String getFinalAssessment(Integer devFinalAssessment) {
        if (devFinalAssessment == null) {
            return "";
        }
        if (devFinalAssessment.equals(Integer.valueOf(1))) {
            return "Точно нет";
        }
        if (devFinalAssessment.equals(Integer.valueOf(2))) {
            return "Скорее нет";
        }
        if (devFinalAssessment.equals(Integer.valueOf(3))) {
            return "Скорее да";
        }
        if (devFinalAssessment.equals(Integer.valueOf(4))) {
            return "Точно да";
        }
        return "";
    }
    
    private String getValue(Object obj){
        if(obj != null){
            return obj.toString();
        }
        return "";
    }

    private class PreparedData {

        Photo photo;

        String fio;
        String highSchool;
        String course;
        String faculty;
        String chair;
        String speciality;
        String endYear;

        String email;
        String phoneNumber;
        String skype;
        String otherContacts;

        String interviewDate;
        String wasOnInterview;

        String hrInterviewer;
        String isHrWantWorkWith;
        String isHrWantTake;
        String hrImpression;

        String techInterviewer;
        String isTechWantWorkWith;
        String isTechWantTake;
        String javaKnowledge;
        String sqlKnowledge;
        String techImpression;

        String traineeship;
        String jobInNC;
        String typeOfWork;

        String ownEstimation;
        String additionalSkills;
        String expierence;
        String reasons;
        String additionalInfo;

        byte[] getPhoto(String path) {
            if (new File(path).exists()) {
                InputStream is = null;
                try {
                    is = new FileInputStream(path);
                    byte[] bytes = IOUtils.toByteArray(is);
                    return bytes;
                } catch (FileNotFoundException ex) {
                     LOGGER.error(path + "- photo is null! FileNotFoundException", ex);
                    return null;
                } catch (IOException ex) {
                    LOGGER.error(path + "- photo is null! IOException", ex);
                    return null;
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (IOException ex) {
                        LOGGER.error(ex.getMessage(), ex);
                    }
                }
            }
            return null;
        }
        Photo getPhotoInstance(String path){
            byte[] img = getPhoto(path);
            if(img != null){
                Photo ph = new Photo();
                ph.img = img;
                ph.type = path.substring(path.lastIndexOf(".")+1).toLowerCase();
                return ph;
            }
            return null;
        }
    }
    
    private class Photo{
        byte[] img;
        String type;
    }
}
