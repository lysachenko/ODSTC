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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DetailInfoPDFCreator {

    private Font font;
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailInfoPDFCreator.class);

    private final static String[] columns = {"Студент",
            "Дата",
            "Начало интервью",
            "Конец интервью",
            "Время интервью с HR",
            "Время интервью с INT-WER"
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
            addTitle(document);
            addContent(document);
        } catch (DocumentException e) {
            e.printStackTrace();
            LOGGER.info("Can`t createPdf DetailInfo");
        }
        finally {
            document.close();
        }
    }

    protected void addTitle(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        Phrase title = new Phrase("Necracker", setFontProperties(font, 25, 1)); //BOLD=1
        Paragraph paragraph = new Paragraph(title);
        preface.add(paragraph);
        addEmptyLine(preface, 1);

        document.add(preface);
    }

    protected void addContent(Document document) throws DocumentException {
        addCurrentDateAndTime(document);
        addExplainingTitle(document);
        createTable(document);

    }

    private void addExplainingTitle(Document document) throws DocumentException {
        Phrase phrase = new Phrase("This is detailed information of interviews:", setFontProperties(font, 14, 0));
        Paragraph paragraph = new Paragraph(phrase);
        addEmptyLine(paragraph, 1);

        document.add(paragraph);
    }

    private void addCurrentDateAndTime(Document document) throws DocumentException {
        Date currentDate = new Date();

        String datePattern = "dd MMMM yyyy";
        String timePattern ="HH:mm";

        SimpleDateFormat formatter1 = new SimpleDateFormat(datePattern);
        SimpleDateFormat formatter2 = new SimpleDateFormat(timePattern);

        StringBuilder date = new StringBuilder("Date: ");
        StringBuilder time = new StringBuilder("Time: ");

        date.append(formatter1.format(currentDate));
        time.append(formatter2.format(currentDate));

        Phrase phraseDate = new Phrase(date.toString(), setFontProperties(font, 14, 0));
        Paragraph paragraph = new Paragraph(phraseDate);

        Phrase phraseTime = new Phrase(time.toString(), setFontProperties(font, 14, 0));
        Paragraph paragraph2 = new Paragraph(phraseTime);

        document.add(paragraph);
        document.add(paragraph2);
    }

    public  void createTable(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(columns.length);
        table.setWidths(new float[]{2, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});

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

        for(int i=0; i<list.size(); i++) {
            table.addCell(new Phrase(list.get(i).getStudent(), setFontProperties(font, 12, 0)));
            table.addCell(list.get(i).getDateInterview());
            table.addCell(list.get(i).getStartInterview());
            table.addCell(list.get(i).getEndInterview());
            table.addCell(list.get(i).getHrTime().toString());
            table.addCell(list.get(i).getInterviewTime().toString());
        }

        table.addCell(new Phrase());
    }

    private void addTableHeaders(PdfPTable table) throws IOException, DocumentException {

        for(int i=0; i<columns.length; i++){
            PdfPCell c1 = new PdfPCell(new Phrase(columns[i], setFontProperties(font, 12, 1)));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
        }
        table.setHeaderRows(1);
    }

    private  void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void setTimesFontPath(String timesFontPath) throws IOException, DocumentException {
        font = FontFactory.getFont(timesFontPath, "cp1251", BaseFont.EMBEDDED);
    }

    private Font setFontProperties(Font font, int size, int style){
        Font anotherFont = font;
        anotherFont.setSize(size);
        anotherFont.setStyle(style);
        return anotherFont;
    }
}
