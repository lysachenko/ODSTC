package com.netcracker.tc.server.util.xls;

import com.netcracker.tc.server.persistence.model.interview.DevInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.interview.QAInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.resume.QAResumeDetail;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.impl.ImageServiceImpl;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QAResumeXlsManager extends AbstractXlsManager{

    private static final Logger LOGGER = LoggerFactory.getLogger(QAResumeXlsManager.class);

    public void writeWorkbook(List devResumeResults) {
        Sheet excelSheet = this.workbook.getSheetAt(0);
        this.drawing = excelSheet.createDrawingPatriarch();

        Row sourceRow = excelSheet.getRow(2);

        for (int i = 1; i < devResumeResults.size(); i++) {
            copyRow(excelSheet, 3, i + 3);
        }
        for (int i = 0; i < devResumeResults.size(); i++) {
            writeRow(excelSheet, (InterviewSlot)devResumeResults.get(i), i + 3);
        }
    }

    protected void copyRow(Sheet worksheet, int sourceRowNum, int destinationRowNum) {
        Row newRow = worksheet.getRow(destinationRowNum);
        Row sourceRow = worksheet.getRow(sourceRowNum);
        if (newRow != null) {
            worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
        } else {
            newRow = worksheet.createRow(destinationRowNum);
        }
        if (sourceRow != null) {
            newRow.setHeight(sourceRow.getHeight());
            for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
                Cell oldCell = sourceRow.getCell(i);
                Cell newCell = newRow.createCell(i);
                if (oldCell == null) {
                    newCell = null;
                } else {
                    CellStyle newCellStyle = oldCell.getCellStyle();
                    newCell.setCellStyle(newCellStyle);
                    if (newCell.getCellComment() != null) {
                        newCell.setCellComment(oldCell.getCellComment());
                    }
                    if (oldCell.getHyperlink() != null) {
                        newCell.setHyperlink(oldCell.getHyperlink());
                    }
                    newCell.setCellType(oldCell.getCellType());
                    switch (oldCell.getCellType()) {
                        case 3:
                            newCell.setCellValue(oldCell.getStringCellValue());
                            break;
                        case 4:
                            newCell.setCellValue(oldCell.getBooleanCellValue());
                            break;
                        case 5:
                            newCell.setCellErrorValue(oldCell.getErrorCellValue());
                            break;
                        case 2:
                            newCell.setCellFormula(oldCell.getCellFormula());
                            break;
                        case 0:
                            newCell.setCellValue(oldCell.getNumericCellValue());
                            break;
                        case 1:
                            newCell.setCellValue(oldCell.getRichStringCellValue());
                    }
                }
            }
        }
    }

    public void writeToFile(String filePath)
            throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filePath);

        this.workbook.write(fileOut);
        fileOut.close();
    }

    protected void writeRow(Sheet worksheet, InterviewSlot interviewSlot, int rowNum) {
        Row row = worksheet.getRow(rowNum);

        fillUserInformation(row, interviewSlot.getUser());
        fillInterviewResult(worksheet, rowNum, interviewSlot);
    }

    protected void fillUserInformation(Row row, User user) {
        Resume resume = user.getResume();
        QAResumeDetail qaResumeDetail = resume.getQaResumeDetail();

        String photoPath = ImageServiceImpl.userPhotoFolderPath + File.separator + resume.getPhotoPath();
        createPhoto(row.getRowNum(), 1, photoPath);
        getCell(row, 0).setCellValue(resume.getSurname() + " " + resume.getName() + " " + resume.getLastName());

//        if (qaResumeDetail != null) {
//            if (qaResumeDetail.getInstitute() != null) {
//                if (qaResumeDetail.getInstitute().getId().equals(InstituteDTO.OTHER_INSTITUTE_ID)) {
//                    if (qaResumeDetail.getInstituteOtherName() != null) {
//                        getCell(row, 16).setCellValue(qaResumeDetail.getInstituteOtherName());
//                    }
//                } else {
//                    getCell(row, 16).setCellValue(qaResumeDetail.getInstitute().getDescription());
//                }
//            }
//            getCell(row, 17).setCellValue(String.valueOf(qaResumeDetail.getCourse()));
//            getCell(row, 18).setCellValue(String.valueOf(qaResumeDetail.getFaculty()));
//            if (qaResumeDetail.getGraduationYear() != null) {
//                getCell(row, 19).setCellValue(String.valueOf(qaResumeDetail.getGraduationYear()));
//            }
//            if (qaResumeDetail.getIsStudent() != null){
//                getCell(row, 20).setCellValue(qaResumeDetail.getIsStudent() ? "Ещё учусь" : "Выпускник");
//            }
//            if (qaResumeDetail.getOtherContacts() != null) {
//                getCell(row, 24).setCellValue(String.valueOf(qaResumeDetail.getOtherContacts()));
//            }
//
//            setValue(row, qaResumeDetail.getTrainingCenterInterest(), 25);
//            setValue(row, qaResumeDetail.getWorkInNetCrackerInterest(), 26);
//            getCell(row, 27).setCellValue(String.valueOf(qaResumeDetail.getOtherInterests()));
//            setValue(row, qaResumeDetail.getQaDevelopment(), 28);
//            setValue(row, qaResumeDetail.getSoftwareDevelopment(), 29);
//            getCell(row, 30).setCellValue(String.valueOf(qaResumeDetail.getOtherJobInterests()));
//
//            setValue(row, qaResumeDetail.getQaExpertWorkType(), 31);
//            setValue(row, qaResumeDetail.getQaAutomationWorkType(), 32);
//            setValue(row, qaResumeDetail.getQaDevelopmentWorkType(), 33);
//            setValue(row, qaResumeDetail.getSoftwareDevelopmentWorkType(), 34);
//            setValue(row, qaResumeDetail.getLeadershipWorkType(), 35);
//            getCell(row, 36).setCellValue(String.valueOf(qaResumeDetail.getOtherWorkTypeSpecific()));
//
//            setValue(row, qaResumeDetail.getSoftwareDevLifeCycle(), 37);
//            setValue(row, qaResumeDetail.getQaRoleInLifeCycle(), 38);
//            setValue(row, qaResumeDetail.getWhatIsTestCase(), 39);
//            setValue(row, qaResumeDetail.getWhatIsDefect(), 40);
//            setValue(row, qaResumeDetail.getTestingType(), 41);
//
//            setValue(row, qaResumeDetail.getNetworkTechnology(), 42);
//            setValue(row, qaResumeDetail.getOOP(), 43);
//            setValue(row, qaResumeDetail.getDbSql(), 44);
//            setValue(row, qaResumeDetail.getClientServerArchitectureAndWeb(), 45);
//            getCell(row, 46).setCellValue(String.valueOf(qaResumeDetail.getOtherSkillsLevel()));
//
//            getCell(row, 47).setCellValue(String.valueOf(qaResumeDetail.getWorkExperience()));
//            setValue(row, qaResumeDetail.getEnglishReadLevel(), 48);
//            setValue(row, qaResumeDetail.getEnglishWriteLevel(), 49);
//            setValue(row, qaResumeDetail.getEnglishSpeakLevel(), 50);
//
//            getCell(row, 51).setCellValue(String.valueOf(qaResumeDetail.getWhereYouKnowAboutTC()));
//            getCell(row, 52).setCellValue(String.valueOf(qaResumeDetail.getWhyTakeYouInNetCracker()));
//            getCell(row, 53).setCellValue(String.valueOf(qaResumeDetail.getMoreInformationAboutYou()));
//        }
//        getCell(row, 21).setCellValue(String.valueOf(resume.getEmail()));
//        if (resume.getTelephoneNum() != null) {
//            getCell(row, 22).setCellValue(resume.getTelephoneNum());
//        }
//        if (resume.getSkype() != null) {
//            getCell(row, 23).setCellValue(resume.getSkype());
//        }
    }

    private void setValue(Row row, Boolean trainingCenterInterest, int colNum) {
        if (trainingCenterInterest != null) {
            getCell(row, colNum).setCellValue(trainingCenterInterest ? "+" : "-");
        }
    }

    private void setValue(Row row, Integer trainingCenterInterest, int colNum){
        if (trainingCenterInterest != null) {
            getCell(row, colNum).setCellValue(trainingCenterInterest.intValue());
        }
    }

    protected void fillInterviewResult(Sheet worksheet, int rowNum, InterviewSlot interviewSlot) {
        InterviewResult interviewResult = interviewSlot.getInterviewResult();
        Row row = worksheet.getRow(rowNum);

        if (interviewResult != null) {
            QAInterviewResultDetail qaResult = interviewResult.getQaInterviewResultDetail();
            if (interviewResult.getInterviewer() != null) {
                Resume resume = interviewResult.getInterviewer().getResume();
                getCell(row, 16).setCellValue(resume.getSurname() + " " + resume.getName());
            }

            setValue(row, qaResult.getQaKnowledge1(), 2);
            setValue(row, qaResult.getQaKnowledge2(), 3);
            setValue(row, qaResult.getQaKnowledge3(), 4);
            setValue(row, qaResult.getQaKnowledge4(), 5);
            setValue(row, qaResult.getQaKnowledge5(), 6);
            setValue(row, qaResult.getQaKnowledge6(), 7);

            setValue(row, qaResult.getItKnowledge1(), 8);
            setValue(row, qaResult.getItKnowledge2(), 9);
            setValue(row, qaResult.getItKnowledge3(), 10);
            setValue(row, qaResult.getItKnowledge4(), 11);

            getCell(row, 12).setCellValue(formatString(qaResult.getInterviewerOther()));
            if (qaResult.getInterviewerWorkWithUser() != null) {
                getCell(row, 13).setCellValue(qaResult.getInterviewerWorkWithUser().booleanValue() ? "Да" : "Нет");
            }

            getCell(row, 14).setCellValue(formatString(qaResult.getInterviewerBasicInformation()));

            getCell(row, 15).setCellValue(getFinalAssessment(qaResult.getInterviewerFinalAssessment()));

            getCell(row, 21).setCellValue(formatString(qaResult.getHrOtherInformation()));
            if (qaResult.getHrWorkWithUser() != null) {
                getCell(row, 23).setCellValue(qaResult.getHrWorkWithUser() ? "Да" : "Нет");
            }
            getCell(row, 22).setCellValue(getFinalAssessment(qaResult.getHrFinalAssessment()));
        }
        getCell(row, 17).setCellValue(interviewSlot.getInterview().getInterviewDate());

    }

    private String formatString(String interviewerOther) {
        if (interviewerOther == null){
            return "";
        }

        return interviewerOther;
    }

    private int getValue(Integer qaKnowledge1) {
        if (qaKnowledge1 != null){
            return qaKnowledge1;
        }
        return 0;
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

    protected Cell getCell(Row row, int cellNum) {
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        return cell;
    }
}