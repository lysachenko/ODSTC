package com.netcracker.tc.server.util.xls;

import com.netcracker.tc.server.persistence.model.interview.DevInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.resume.DevResumeDetail;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.impl.ImageServiceImpl;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.velocity.texen.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public abstract class AbstractXlsManager implements XlsManagerI {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractXlsManager.class);
    protected Workbook workbook = null;
    protected Drawing drawing = null;

    public void initWorkbook() {
        this.workbook = new HSSFWorkbook();
    }

    public void loadTemplate(String templateXlsFilePath) {
        try {
            this.workbook = WorkbookFactory.create(new File(templateXlsFilePath));
        } catch (FileNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (InvalidFormatException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public void writeWorkbook(List devResumeResults) {
        Sheet excelSheet = this.workbook.getSheetAt(0);
        this.drawing = excelSheet.createDrawingPatriarch();
        for (int i = 0; i < devResumeResults.size() - 1; i++) {
            copyRow(excelSheet, i + 2, i + 3);
        }
        for (int i = 0; i < devResumeResults.size(); i++) {
            writeRow(excelSheet, (InterviewSlot) devResumeResults.get(i), i + 2);
        }
    }

    public void writeToFile(String filePath)
            throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filePath);

        this.workbook.write(fileOut);
        fileOut.close();
    }

    public void writeToStream(OutputStream stream)
            throws IOException {
        this.workbook.write(stream);
        stream.close();
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
            for (int i = 0; i < worksheet.getNumMergedRegions(); i++) {
                CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
                if (cellRangeAddress.getFirstRow() == sourceRow.getRowNum()) {
                    CellRangeAddress newCellRangeAddress = new CellRangeAddress(newRow.getRowNum(), newRow.getRowNum() + (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow()), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn());
                    worksheet.addMergedRegion(newCellRangeAddress);
                }
            }
        }
    }

    protected void writeRow(Sheet worksheet, InterviewSlot interviewSlot, int rowNum) {
        Row row = worksheet.getRow(rowNum);

        fillUserInformation(row, interviewSlot.getUser());
        fillInterviewResult(row, interviewSlot.getInterviewResult());
    }

    protected void fillUserInformation(Row row, User user) {
        Resume resume = user.getResume();
        DevResumeDetail devResumeDetail = resume.getDevResumeDetail();

        getCell(row, 0).setCellValue(row.getRowNum() - 1);
        String photoPath = ImageServiceImpl.userPhotoFolderPath + File.separator + resume.getPhotoPath();
        createPhoto(row.getRowNum(), 1, photoPath);
        getCell(row, 2).setCellValue(resume.getSurname() + " " + resume.getName() + " " + resume.getLastName());
        if (devResumeDetail != null) {
            if (devResumeDetail.getInstitute() != null) {
                if (devResumeDetail.getInstitute().getId().equals(InstituteDTO.OTHER_INSTITUTE_ID)) {
                    if (devResumeDetail.getInstituteOtherName() != null) {
                        getCell(row, 3).setCellValue(devResumeDetail.getInstituteOtherName());
                    }
                } else {
                    getCell(row, 3).setCellValue(devResumeDetail.getInstitute().getDescription());
                }
            }
            getCell(row, 4).setCellValue(String.valueOf(devResumeDetail.getCourse()));
            getCell(row, 5).setCellValue(String.valueOf(devResumeDetail.getFaculty()));
            getCell(row, 6).setCellValue(String.valueOf(devResumeDetail.getDepartment()));
            if (devResumeDetail.getGraduationYear() != null) {
                getCell(row, 7).setCellValue(String.valueOf(devResumeDetail.getGraduationYear()));
            }
            if (devResumeDetail.getOtherContacts() != null) {
                getCell(row, 11).setCellValue(String.valueOf(devResumeDetail.getOtherContacts()));
            }
        }
        getCell(row, 8).setCellValue(String.valueOf(resume.getEmail()));
        if (resume.getTelephoneNum() != null) {
            getCell(row, 9).setCellValue(resume.getTelephoneNum());
        }
        if (resume.getSkype() != null) {
            getCell(row, 10).setCellValue(resume.getSkype());
        }
    }

    protected void createPhoto(int row, int col, String imagePath) {
        if (new File(imagePath).exists()) {
            InputStream is = null;
            try {
                is = new FileInputStream(imagePath);
                byte[] bytes = IOUtils.toByteArray(is);
                int pictureIdx = this.workbook.addPicture(bytes, 5);
                is.close();

                CreationHelper helper = this.workbook.getCreationHelper();
                ClientAnchor anchor = helper.createClientAnchor();

                anchor.setCol1(col);
                anchor.setRow1(row);
                anchor.setCol2(col + 1);
                anchor.setRow2(row + 1);

                Picture pict = this.drawing.createPicture(anchor, pictureIdx);
                return;
            } catch (FileNotFoundException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage(), ex);
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
    }

    protected void fillInterviewResult(Row row, InterviewResult interviewResult) {
        if (interviewResult != null) {
            DevInterviewResultDetail devInterviewResultDetail = interviewResult.getDevInterviewResultDetail();
            if (interviewResult.getInterviewer() != null) {
                getCell(row, 12).setCellValue(interviewResult.getInterviewer().getLogin());
            }
            getCell(row, 13).setCellValue(getFinalAssessment(devInterviewResultDetail.getDevFinalAssessment()));
            if (devInterviewResultDetail.getJavaSkill() != null) {
                getCell(row, 14).setCellValue(devInterviewResultDetail.getJavaSkill());
            }
            if (devInterviewResultDetail.getSqlSkill() != null) {
                getCell(row, 15).setCellValue(devInterviewResultDetail.getSqlSkill());
            }
            if (devInterviewResultDetail.getInterviewerWorkWithUser() != null) {
                getCell(row, 16).setCellValue(devInterviewResultDetail.getInterviewerWorkWithUser().booleanValue() ? "Да" : "Нет");
            }
            if (devInterviewResultDetail.getInterviewerOtherInformation() != null) {
                getCell(row, 17).setCellValue(devInterviewResultDetail.getInterviewerOtherInformation());
            }
            getCell(row, 18).setCellValue(getFinalAssessment(devInterviewResultDetail.getHrFinalAssessment()));
            if (devInterviewResultDetail.getHrWorkWithUser() != null) {
                getCell(row, 19).setCellValue(devInterviewResultDetail.getHrWorkWithUser().booleanValue() ? "Да" : "Нет");
            }
            if (devInterviewResultDetail.getHrOtherInformation() != null) {
                getCell(row, 20).setCellValue(devInterviewResultDetail.getHrOtherInformation());
            }
        }
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
