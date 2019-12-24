package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.service.api.XlsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailInfoDownloadServlet extends AutoinjectingRemoteServiceServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetailInfoDownloadServlet.class);

    @Autowired
    XlsService xlsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.info("Invoked DetailInfoDownloadServlet");

        try {
            downloadDetailInfoReport(resp);
        } catch (ServiceException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
        catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            LOGGER.error("Can't create xlsx document. ", e);
        }
    }

    private void downloadDetailInfoReport(HttpServletResponse response) throws IOException, ServiceException, SessionExpiredException {
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=detailInfo.xlsx");

            xlsService.createDetailInfoXls(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            LOGGER.info("Xls file sent");
    }

}
