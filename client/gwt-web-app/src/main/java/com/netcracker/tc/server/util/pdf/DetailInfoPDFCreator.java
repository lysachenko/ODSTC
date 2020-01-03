package com.netcracker.tc.server.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.netcracker.tc.server.persistence.model.report.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class DetailInfoPDFCreator {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    private BaseFont timesFont;


    private static final Logger LOGGER = LoggerFactory.getLogger(DetailInfoPDFCreator.class);

    private final static String[] columns = {"Студент",
            "Дата",
            "Начало интервью",
            "Конец интервью",
            "Длительность интервью HR",
            "Длительность с INT-WER"
    };
    private List<Report> list = new ArrayList<Report>();

    public DetailInfoPDFCreator(){}

    public DetailInfoPDFCreator(List<Report> list){
        this.list =list;
    }

    public void setList(List<Report> list) {
        this.list = list;
    }

    public void createPDF(OutputStream stream){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, stream);
            document.open();
            addTitlePage(document);
            addContent(document);
        } catch (DocumentException e) {
            e.printStackTrace();
            LOGGER.info("Can`t createPdf DetailInfo");
        }
        finally {
            document.close();
        }
    }
    public  void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Necracker", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("This is detailed information of interviews:", smallFont));
        addEmptyLine(preface, 2);
        document.add(preface);
    }

    public  void createTable(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(columns.length);
        table.setWidths(new int[]{2, 1, 1, 1, 1, 1});

        try {
            addTableHeaders(table);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("Problems with russian encoding");
        }
        addTableContent(table);
        document.add(table);
    }

    private void addTableContent(PdfPTable table) {

        float [] pointColumnWidths = {150F, 150F, 150F};
        for(int i=0; i<list.size(); i++) {
            table.addCell(list.get(i).getStudent());
            table.addCell(list.get(i).getDateInterview().toString());
            table.addCell(list.get(i).getStartInterview().toString());
            table.addCell(list.get(i).getEndInterview().toString());
            table.addCell(list.get(i).getHrTime().toString());
            table.addCell(list.get(i).getInterviewTime().toString());
        }
    }

    private void addTableHeaders(PdfPTable table) throws IOException, DocumentException {

        //РУССКАЯ КОДИРОВКА ?
        BaseFont helvetica = BaseFont.createFont( BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        Font russianFont =new Font(helvetica, 12);

        for(int i=0; i<columns.length; i++){
            PdfPCell c1 = new PdfPCell(new Phrase(columns[i], russianFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
        }
        table.setHeaderRows(1);
    }

    public   void addContent(Document document) throws DocumentException {
        createTable(document);
    }

    private  void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void setTimesFontPath(String timesFontPath) throws IOException, DocumentException {
        timesFont = BaseFont.createFont(timesFontPath, "cp1251", BaseFont.EMBEDDED);
    }

}
