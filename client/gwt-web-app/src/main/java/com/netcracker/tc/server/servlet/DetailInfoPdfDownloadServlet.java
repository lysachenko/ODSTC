package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.service.api.PDFService;
import com.netcracker.tc.server.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailInfoPdfDownloadServlet extends AutoinjectingRemoteServiceServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailInfoPdfDownloadServlet.class);

    @Autowired
    PDFService pdfService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            downloadFile(req, resp);
        } catch (ServiceException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void downloadFile(HttpServletRequest req, HttpServletResponse response) throws IOException, ServiceException {
        pdfService.createActiveDetailInfoPDF(response.getOutputStream());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + "detailInfo.pdf");

        LOGGER.info("DetailInfoPDF send");
    }

}
