package com.netcracker.tc.server.util.xls;

import com.netcracker.tc.server.persistence.model.report.Report;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class DetailInfoXlsManager {

    private final static String[] columns = {"Student",
            "Date",
            "BeginWithHr",
            "endWithHR",
            "beginWithInterview",
            "endWithInterview"
    };

    private Workbook workbook;
    private List<PreparedData> data;

    public void createWorkbook() {
        this.workbook =  new XSSFWorkbook();
    }

    public void writeWorkbook(List<Report> list) {
        // Create a Sheet
        Sheet sheet =  workbook.createSheet("DetailInfo");

        // Create a Font for styling header cells
        Font headerFont =  workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);


        // Create a CellStyle with the font
        CellStyle headerCellStyle =  workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow((short) 0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        //convert into data-format


        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(Report report: list ) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(report.getStudent());
            row.createCell(1).setCellValue(report.getDateInterview().toString());
            row.createCell(2).setCellValue(report.getStartInterview().toString());
            row.createCell(3).setCellValue(report.getEndInterview().toString());
            row.createCell(4).setCellValue(report.getHrTime().toString());
            row.createCell(5).setCellValue(report.getInterviewTime().toString());

        }

        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }




    public void writeToStream(OutputStream stream) throws IOException {
        this.workbook.write(stream);
        stream.close();
    }

    private class PreparedData{
        String student;
        String dateInterview;
        String startHr;
        String endHr;
        String startInterview;
        String endInterview;
    }

}
